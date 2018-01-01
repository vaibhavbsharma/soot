package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.util.*;
import java.util.Collection;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast interface */
public interface Variable {

  public String name();

  public TypeDecl type();

  public Collection<TypeDecl> throwTypes();

  public boolean isParameter();

  // 4.5.3

  // 4.5.3
  public boolean isClassVariable();

  public boolean isInstanceVariable();

  public boolean isMethodParameter();

  public boolean isConstructorParameter();

  public boolean isExceptionHandlerParameter();

  public boolean isLocalVariable();

  // 4.5.4

  // 4.5.4
  public boolean isFinal();

  public boolean isVolatile();

  public boolean isBlank();

  public boolean isStatic();

  public boolean isSynthetic();

  public TypeDecl hostType();

  public Expr getInit();

  public boolean hasInit();

  public Constant constant();

  public Modifiers getModifiers();
  /**
   * @attribute syn
   * @aspect SourceDeclarations
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.5Frontend/Generics.jrag:1519
   */
  @SuppressWarnings({"unchecked", "cast"})
  public Variable sourceVariableDecl();
}
