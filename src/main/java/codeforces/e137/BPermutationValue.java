package codeforces.e137;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BPermutationValue {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    out.print(1, n, "");
    for (int i = 2; i <= n - 1; i++) {
      out.print(i, "");
    }
    out.println();
  }
}
