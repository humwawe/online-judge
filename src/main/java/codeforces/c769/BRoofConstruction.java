package codeforces.c769;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BRoofConstruction {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt() - 1;
    int t = Integer.highestOneBit(n);
    for (int i = 1; i <= n; i++) {
      if (i == t) {
        out.print(0 + " " + i + " ");
      } else {
        out.print(i + " ");
      }
    }
    out.println();
  }
}
