package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast interface */
public interface GenericTypeDecl {

  TypeDecl original();

  int getNumTypeParameter();

  TypeVariable getTypeParameter(int index);

  List getTypeParameterList();

  public String fullName();

  public String typeName();

  public TypeDecl makeGeneric(Signatures.ClassSignature s);

  public SimpleSet addTypeVariables(SimpleSet c, String name);

  public List createArgumentList(ArrayList params);

  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.5Frontend/Generics.jrag:158
   */
  @SuppressWarnings({"unchecked", "cast"})
  public boolean isGenericType();
  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.5Frontend/Generics.jrag:163
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDecl rawType();
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.5Frontend/Generics.jrag:708
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDecl lookupParTypeDecl(ParTypeAccess p);
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat
   *     /Users/eric/Documents/workspaces/clara-soot/JastAddJ/Java1.5Frontend/Generics.jrag:714
   */
  @SuppressWarnings({"unchecked", "cast"})
  public TypeDecl lookupParTypeDecl(ArrayList list);
}
