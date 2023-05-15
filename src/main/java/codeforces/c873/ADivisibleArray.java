package codeforces.c873;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ADivisibleArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      out.print(2 * i, "");
    }
    out.println();
  }
}
