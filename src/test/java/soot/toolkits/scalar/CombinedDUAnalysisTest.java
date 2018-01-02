package soot.toolkits.scalar;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import soot.Local;
import soot.Unit;
import soot.toolkits.graph.UnitGraph;

public class CombinedDUAnalysisTest {

  public static CombinedAnalysis v(final UnitGraph graph) {
    return new CombinedAnalysis() {
      CombinedDUAnalysis combined = new CombinedDUAnalysis(graph);
      SimpleLocalDefs defs = new SimpleLocalDefs(graph);
      SimpleLocalUses uses = new SimpleLocalUses(graph, defs);
      SimpleLiveLocals live = new SimpleLiveLocals(graph);

      @Override
      public List<Unit> getDefsOfAt(Local l, Unit s) {
        HashSet<Unit> hs1 = new HashSet<>(combined.getDefsOfAt(l, s));
        HashSet<Unit> hs2 = new HashSet<>(defs.getDefsOfAt(l, s));
        if (!hs1.equals(hs2)) {
          throw new RuntimeException(
              "Defs of " + l + " in " + s + "\ncombined: " + hs1 + "\nsimple: " + hs2);
        }
        return combined.getDefsOfAt(l, s);
      }

      @Override
      public List<UnitValueBoxPair> getUsesOf(Unit u) {
        HashSet<UnitValueBoxPair> hs1 = new HashSet<>(combined.getUsesOf(u));
        HashSet<UnitValueBoxPair> hs2 = new HashSet<>(uses.getUsesOf(u));
        if (!hs1.equals(hs2)) {
          throw new RuntimeException("Uses of " + u + "\ncombined: " + hs1 + "\nsimple: " + hs2);
        }
        return combined.getUsesOf(u);
      }

      @Override
      public List<Local> getLiveLocalsBefore(Unit u) {
        HashSet<Local> hs1 = new HashSet<>(combined.getLiveLocalsBefore(u));
        HashSet<Local> hs2 = new HashSet<>(live.getLiveLocalsBefore(u));
        if (!hs1.equals(hs2)) {
          throw new RuntimeException("llb of " + u + "\ncombined: " + hs1 + "\nsimple: " + hs2);
        }
        return combined.getLiveLocalsBefore(u);
      }

      @Override
      public List<Local> getLiveLocalsAfter(Unit u) {
        HashSet<Local> hs1 = new HashSet<>(combined.getLiveLocalsAfter(u));
        HashSet<Local> hs2 = new HashSet<>(live.getLiveLocalsAfter(u));
        if (!hs1.equals(hs2)) {
          throw new RuntimeException("lla of " + u + "\ncombined: " + hs1 + "\nsimple: " + hs2);
        }
        return combined.getLiveLocalsAfter(u);
      }

      @Override
      public List<Unit> getDefsOf(Local l) {
        HashSet<Unit> hs1 = new HashSet<>(combined.getDefsOf(l));
        HashSet<Unit> hs2 = new HashSet<>(defs.getDefsOf(l));
        if (!hs1.equals(hs2)) {
          throw new RuntimeException("Defs of " + l + "\ncombined: " + hs1 + "\nsimple: " + hs2);
        }
        return combined.getDefsOf(l);
      }
    };
  }

  @Test
  public void test() {
    // TODO: build a proper test harness
  }
}
