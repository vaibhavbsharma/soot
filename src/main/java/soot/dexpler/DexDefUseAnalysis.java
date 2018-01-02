package soot.dexpler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.Body;
import soot.Local;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.AssignStmt;
import soot.jimple.DefinitionStmt;
import soot.toolkits.scalar.LocalDefs;

/**
 * Simplistic caching, flow-insensitive def/use analysis
 *
 * @author Steven Arzt
 */
public class DexDefUseAnalysis implements LocalDefs {

  private final Body body;
  private Map<Local, Set<Unit>> localToUses = new HashMap<>();
  private Map<Local, Set<Unit>> localToDefs = new HashMap<>();
  private Map<Local, Set<Unit>> localToDefsWithAliases = new HashMap<>();

  public DexDefUseAnalysis(Body body) {
    this.body = body;
  }

  public Set<Unit> getUsesOf(Local l) {
    Set<Unit> uses = localToUses.get(l);
    if (uses == null) {
      uses = new HashSet<>();
      for (Unit u : body.getUnits()) {
        for (ValueBox vb : u.getUseBoxes()) {
          if (vb.getValue() == l) {
            uses.add(u);
          }
        }
      }
      localToUses.put(l, uses);
    }
    return uses;
  }

  /**
   * Collect definitions of l in body including the definitions of aliases of l. This analysis
   * exploits that the problem is flow-insensitive anyway.
   *
   * <p>In this context an alias is a local that propagates its value to l.
   *
   * @param l the local whose definitions are to collect
   */
  protected Set<Unit> collectDefinitionsWithAliases(Local l) {
    Set<Unit> defs = localToDefsWithAliases.get(l);
    if (defs == null) {
      Set<Local> seenLocals = new HashSet<>();
      defs = new HashSet<>();

      List<Local> newLocals = new ArrayList<>();
      newLocals.add(l);

      while (!newLocals.isEmpty()) {
        Local curLocal = newLocals.remove(0);

        // Definition of l?
        for (Unit defUnit : getDefsOf(curLocal)) {
          defs.add(defUnit);

          DefinitionStmt defStmt = (DefinitionStmt) defUnit;
          if (defStmt.getRightOp() instanceof Local
              && seenLocals.add((Local) defStmt.getRightOp())) {
            newLocals.add((Local) defStmt.getRightOp());
          }
        }

        // Use of l?
        for (Unit use : getUsesOf(curLocal)) {
          if (use instanceof AssignStmt) {
            AssignStmt assignUse = (AssignStmt) use;
            if (assignUse.getRightOp() == curLocal
                && assignUse.getLeftOp() instanceof Local
                && seenLocals.add((Local) assignUse.getLeftOp())) {
              newLocals.add((Local) assignUse.getLeftOp());
            }
          }
        }
      }
      localToDefsWithAliases.put(l, defs);
    }
    return defs;
  }

  @Override
  public List<Unit> getDefsOfAt(Local l, Unit s) {
    return getDefsOf(l);
  }

  @Override
  public List<Unit> getDefsOf(Local l) {
    Set<Unit> defs = localToDefs.get(l);
    if (defs == null) {
      defs = new HashSet<>();
      for (Unit u : body.getUnits()) {
        if (u instanceof DefinitionStmt) {
          if (((DefinitionStmt) u).getLeftOp() == l) {
            defs.add(u);
          }
        }
      }
      localToDefs.put(l, defs);
    }
    return new ArrayList<>(defs);
  }
}
