package codeforces.c873;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.MathMeth;

public class BPermutationSwap {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long gcd = 0;
    for (int i = 1; i <= n; i++) {
      long x = in.nextInt();
      gcd = MathMeth.gcd(Math.abs(x - i), gcd);
    }
    out.println(gcd);

  }
}
