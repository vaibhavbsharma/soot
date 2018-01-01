package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast interface */
public interface Parameterization {

  boolean isRawType();

  TypeDecl substitute(TypeVariable typeVariable);
}
