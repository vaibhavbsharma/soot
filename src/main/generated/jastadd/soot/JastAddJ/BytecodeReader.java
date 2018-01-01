package soot.JastAddJ;

import beaver.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.zip.*;
import soot.*;
import soot.jimple.*;
import soot.util.*;

/** @ast interface */
public interface BytecodeReader {

  CompilationUnit read(InputStream is, String fullName, Program p)
      throws FileNotFoundException, IOException;
}
