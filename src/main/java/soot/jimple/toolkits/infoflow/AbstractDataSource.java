package soot.jimple.toolkits.infoflow;

import soot.NullType;
import soot.Type;
import soot.UnitPrinter;
import soot.Value;
import soot.ValueBox;
import soot.util.Switch;

import java.util.Collections;
import java.util.List;

// Wraps any object as a Value

public class AbstractDataSource implements Value {
  Object sourcename;

  public AbstractDataSource(Object sourcename) {
    this.sourcename = sourcename;
  }

  @Override
  public List<ValueBox> getUseBoxes() {
    return Collections.emptyList();
  }

  /**
   * Clones the object. Not implemented here.
   */
  @Override
  public Object clone() {
    return new AbstractDataSource(sourcename);
  }

  /**
   * Returns true if this object is structurally equivalent to c. AbstractDataSources are equal and
   * equivalent if their sourcename is the same
   */
  @Override
  public boolean equivTo(Object c) {
    if (sourcename instanceof Value) {
      return (c instanceof AbstractDataSource
          && ((Value) sourcename).equivTo(((AbstractDataSource) c).sourcename));
    }
    return (c instanceof AbstractDataSource
        && ((AbstractDataSource) c).sourcename.equals(sourcename));
  }

  @Override
  public boolean equals(Object c) {
    return (c instanceof AbstractDataSource
        && ((AbstractDataSource) c).sourcename.equals(sourcename));
  }

  /**
   * Returns a hash code consistent with structural equality for this object.
   */
  @Override
  public int equivHashCode() {
    if (sourcename instanceof Value) {
      return ((Value) sourcename).equivHashCode();
    }
    return sourcename.hashCode();
  }

  @Override
  public void toString(UnitPrinter up) {
  }

  @Override
  public Type getType() {
    return NullType.v();
  }

  @Override
  public void apply(Switch sw) {
    throw new RuntimeException("Not Implemented");
  }

  @Override
  public String toString() {
    return "sourceof<" + sourcename.toString() + ">";
  }
}
