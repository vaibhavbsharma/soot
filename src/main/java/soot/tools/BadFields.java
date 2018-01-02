/* Soot - a J*va Optimization Framework
 * Copyright (C) 2003 Ondrej Lhotak
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */

package soot.tools;

import java.util.Iterator;
import java.util.Map;

import soot.G;
import soot.PackManager;
import soot.PrimType;
import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Transform;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.FieldRef;
import soot.jimple.InvokeExpr;
import soot.jimple.StaticFieldRef;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;

public class BadFields extends SceneTransformer {
  public static void main(String[] args) {
    PackManager.v().getPack("cg").add(new Transform("cg.badfields", new BadFields()));
    soot.Main.main(args);
  }

  private SootClass lastClass;
  private SootClass currentClass;

  @Override
  protected void internalTransform(String phaseName, Map<String, String> options) {
    lastClass = null;

    for (SootClass cl : Scene.v().getApplicationClasses()) {

      currentClass = cl;
      handleClass(cl);
      for (Iterator<SootMethod> it = cl.methodIterator(); it.hasNext(); ) {
        handleMethod(it.next());
      }
    }
    Scene.v().setCallGraph(new CallGraph());
  }

  private void handleClass(SootClass cl) {
    for (SootField f : cl.getFields()) {
      if (!f.isStatic()) {
        continue;
      }
      String typeName = f.getType().toString();
      if (typeName.equals("java.lang.Class")) {
        continue;
      }
      if (f.isFinal()) {
        if (f.getType() instanceof PrimType) {
          continue;
        }
        if (typeName.equals("java.io.PrintStream")) {
          continue;
        }
        if (typeName.equals("java.lang.String")) {
          continue;
        }
        if (typeName.equals("java.lang.Object")) {
          continue;
        }
        if (typeName.equals("java.lang.Integer")) {
          continue;
        }
        if (typeName.equals("java.lang.Boolean")) {
          continue;
        }
      }
      warn("Bad field " + f);
    }
  }

  private void warn(String warning) {
    if (lastClass != currentClass) {
      G.v().out.println("In class " + currentClass);
    }
    lastClass = currentClass;
    G.v().out.println("  " + warning);
  }

  private void handleMethod(SootMethod m) {
    if (!m.isConcrete()) {
      return;
    }
    for (ValueBox b : m.retrieveActiveBody().getUseAndDefBoxes()) {
      Value v = b.getValue();
      if (!(v instanceof StaticFieldRef)) {
        continue;
      }
      StaticFieldRef sfr = (StaticFieldRef) v;
      SootField f = sfr.getField();
      if (!f.getDeclaringClass().getName().equals("java.lang.System")) {
        continue;
      }
      if (f.getName().equals("err")) {
        G.v().out.println("Use of System.err in " + m);
      }
      if (f.getName().equals("out")) {
        G.v().out.println("Use of System.out in " + m);
      }
    }
    for (Unit unit : m.getActiveBody().getUnits()) {
      final Stmt s = (Stmt) unit;
      if (!s.containsInvokeExpr()) {
        continue;
      }
      InvokeExpr ie = s.getInvokeExpr();
      SootMethod target = ie.getMethod();
      if (target.getDeclaringClass().getName().equals("java.lang.System")
          && target.getName().equals("exit")) {
        warn("" + m + " calls System.exit");
      }
    }
    if (m.getName().equals("<clinit>")) {
      for (Unit unit : m.getActiveBody().getUnits()) {
        final Stmt s = (Stmt) unit;
        for (ValueBox b : s.getUseBoxes()) {
          Value v = b.getValue();
          if (v instanceof FieldRef) {
            warn(m.getName() + " reads field " + v);
          }
        }
        if (!s.containsInvokeExpr()) {
          continue;
        }
        InvokeExpr ie = s.getInvokeExpr();
        SootMethod target = ie.getMethod();
        calls(target);
      }
    }
  }

  private void calls(SootMethod target) {
    if (target.getName().equals("<init>")) {
      if (target.getDeclaringClass().getName().equals("java.io.PrintStream")) {
        return;
      }
      if (target.getDeclaringClass().getName().equals("java.lang.Boolean")) {
        return;
      }
      if (target.getDeclaringClass().getName().equals("java.lang.Integer")) {
        return;
      }
      if (target.getDeclaringClass().getName().equals("java.lang.String")) {
        return;
      }
      if (target.getDeclaringClass().getName().equals("java.lang.Object")) {
        return;
      }
    }
    if (target.getName().equals("getProperty")) {
      if (target.getDeclaringClass().getName().equals("java.lang.System")) {
        return;
      }
    }
    if (target.getName().equals("charAt")) {
      if (target.getDeclaringClass().getName().equals("java.lang.String")) {
        return;
      }
    }
    warn("<clinit> invokes " + target);
  }
}
