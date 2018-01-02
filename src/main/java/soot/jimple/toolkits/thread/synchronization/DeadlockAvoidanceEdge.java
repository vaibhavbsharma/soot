package soot.jimple.toolkits.thread.synchronization;

import soot.SootClass;

public class DeadlockAvoidanceEdge extends NewStaticLock {
  public DeadlockAvoidanceEdge(SootClass sc) {
    super(sc);
  }

  /** Clones the object. */
  @Override
  public Object clone() {
    return new DeadlockAvoidanceEdge(sc);
  }

  @Override
  public boolean equals(Object c) {
    if (c instanceof DeadlockAvoidanceEdge) {
      return ((DeadlockAvoidanceEdge) c).idnum == idnum;
    }
    return false;
  }

  @Override
  public String toString() {
    return "dae<" + sc.toString() + ">";
  }
}
