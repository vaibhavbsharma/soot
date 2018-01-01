public class ByteProblem {

  public static void main(String[] args) {
    new ByteProblem().reffoo();
  }

  public static final byte TheConstant = 3;

  public void foo(byte x) {}

  public void reffoo() {
    foo(TheConstant);
  }
}
