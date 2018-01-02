package soot.dava.internal.javaRep;

import soot.Type;
import soot.UnitPrinter;

public class DShortcutAssignStmt extends DAssignStmt {
  Type type;

  public DShortcutAssignStmt(DAssignStmt assignStmt, Type type) {
    super(assignStmt.getLeftOpBox(), assignStmt.getRightOpBox());
    this.type = type;
  }

  @Override
  public void toString(UnitPrinter up) {
    up.type(type);
    up.literal(" ");
    super.toString(up);
  }

  @Override
  public String toString() {
    return type.toString()
        + " "
        + leftBox.getValue().toString()
        + " = "
        + rightBox.getValue().toString();
  }
}
