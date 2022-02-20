package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DVasyaAndChess {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n % 2 == 0) {
      out.println("white");
      out.println("1 2");
    } else {
      out.println("black");
    }
  }
}
