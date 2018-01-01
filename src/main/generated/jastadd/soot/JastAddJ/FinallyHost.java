package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast interface */
public interface FinallyHost {

  // public Block getFinally();

  // public Block getFinally();
  public boolean isDUafterFinally(Variable v);

  public boolean isDAafterFinally(Variable v);

  public void emitFinallyCode(Body b);

  /**
   * @attribute syn
   * @aspect Statements
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddExtensions/JimpleBackend/Statements.jrag:319
   */
  @SuppressWarnings({"unchecked", "cast"})
  public soot.jimple.Stmt label_finally_block();
}
