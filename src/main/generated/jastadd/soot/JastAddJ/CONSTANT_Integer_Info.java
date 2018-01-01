package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast class */
public class CONSTANT_Integer_Info extends CONSTANT_Info {

  public int value;

  public CONSTANT_Integer_Info(BytecodeParser parser) {
    super(parser);
    value = p.readInt();
  }

  public String toString() {
    return "IntegerInfo: " + Integer.toString(value);
  }

  public Expr expr() {
    return Literal.buildIntegerLiteral(value);
  }

  public Expr exprAsBoolean() {
    return Literal.buildBooleanLiteral(value == 0);
  }
}
