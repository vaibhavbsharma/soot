package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast class */
public class CONSTANT_Double_Info extends CONSTANT_Info {

  public double value;

  public CONSTANT_Double_Info(BytecodeParser parser) {
    super(parser);
    value = this.p.readDouble();
  }

  public String toString() {
    return "DoubleInfo: " + Double.toString(value);
  }

  public Expr expr() {
    return Literal.buildDoubleLiteral(value);
  }
}
