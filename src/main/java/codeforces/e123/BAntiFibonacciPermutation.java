package codeforces.e123;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BAntiFibonacciPermutation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      int t = n;
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          out.print(1, "");
        } else {
          out.print(t--, "");
        }
      }
      out.println();
    }
  }
}
