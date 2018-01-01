package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast interface */
public interface BranchPropagation {
  public void collectBranches(Collection c);

  public Stmt branchTarget(Stmt branchStmt);

  public void collectFinally(Stmt branchStmt, ArrayList list);

  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.4Frontend/BranchTarget.jrag:32
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Collection targetContinues();
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.4Frontend/BranchTarget.jrag:33
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Collection targetBreaks();
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.4Frontend/BranchTarget.jrag:34
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Collection targetBranches();
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.4Frontend/BranchTarget.jrag:35
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Collection escapedBranches();
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.4Frontend/BranchTarget.jrag:36
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Collection branches();
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.4Frontend/BranchTarget.jrag:39
   */
  @SuppressWarnings({"unchecked", "cast"})
  public boolean targetOf(ContinueStmt stmt);
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.4Frontend/BranchTarget.jrag:40
   */
  @SuppressWarnings({"unchecked", "cast"})
  public boolean targetOf(BreakStmt stmt);
}
