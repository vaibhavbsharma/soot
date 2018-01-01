package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast class */
public class CONSTANT_Float_Info extends CONSTANT_Info {

  public float value;

  public CONSTANT_Float_Info(BytecodeParser parser) {
    super(parser);
    value = p.readFloat();
  }

  public String toString() {
    return "FloatInfo: " + Float.toString(value);
  }

  public Expr expr() {
    return Literal.buildFloatLiteral(value);
  }
}
