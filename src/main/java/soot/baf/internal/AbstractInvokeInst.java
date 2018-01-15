/* Soot - a J*va Optimization Framework
 * Copyright (C) 1999 Patrick Lam, Patrick Pominville and Raja Vallee-Rai
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

/*
 * Modified by the Sable Research Group and others 1997-1999.
 * See the 'credits' file distributed with Soot for the complete list of
 * contributors.  (Soot is distributed at http://www.sable.mcgill.ca/soot)
 */

package soot.baf.internal;

import soot.AbstractJasminClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.UnitPrinter;
import soot.VoidType;

import java.util.Iterator;

abstract class AbstractInvokeInst extends AbstractInst {
  SootMethodRef methodRef;

  public SootMethodRef getMethodRef() {
    return methodRef;
  }

  public SootMethod getMethod() {
    return methodRef.resolve();
  }

  public Type getType() {
    return methodRef.returnType();
  }

  @Override
  public String toString() {
    return getName() + getParameters();
  }

  @Override
  public abstract String getName();

  @Override
  String getParameters() {
    return " " + methodRef.getSignature();
  }

  @Override
  protected void getParameters(UnitPrinter up) {
    up.literal(" ");
    up.methodRef(methodRef);
  }

  @Override
  public int getInCount() {
    return getMethodRef().parameterTypes().size();
  }

  @Override
  public int getOutCount() {
    if (getMethodRef().returnType() instanceof VoidType) {
      return 0;
    } else {
      return 1;
    }
  }

  @Override
  public int getInMachineCount() {
    int count = 0;

    Iterator it = getMethodRef().parameterTypes().iterator();
    while (it.hasNext()) {
      count += AbstractJasminClass.sizeOfType((Type) it.next());
    }
    return count;
  }

  @Override
  public int getOutMachineCount() {
    if (getMethodRef().returnType() instanceof VoidType) {
      return 0;
    } else {
      return AbstractJasminClass.sizeOfType(getMethodRef().returnType());
    }
  }

  @Override
  public boolean containsInvokeExpr() {
    return true;
  }
}
