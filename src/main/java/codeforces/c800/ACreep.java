package codeforces.c800;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ACreep {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    if (a <= b) {
      out.print("01".repeat(a));
      out.println("1".repeat(b - a));
    } else {
      out.print("10".repeat(b));
      out.println("0".repeat(a - b));
    }
  }
}
