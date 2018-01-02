package soot.dava.internal.javaRep;

import soot.AbstractValueBox;
import soot.Value;

public class DArrayInitValueBox extends AbstractValueBox {
  public DArrayInitValueBox(Value value) {
    setValue(value);
  }

  @Override
  public boolean canContainValue(Value value) {
    return (value instanceof DArrayInitExpr);
  }
}
