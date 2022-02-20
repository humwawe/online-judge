package codeforces.c725;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class FInterestingFunction {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int l = in.nextInt();
    int r = in.nextInt();
    out.println(helper(r) - helper(l));
  }

  private int helper(int v) {
    int res = 0;
    while (v > 0) {
      res += v;
      v /= 10;
    }
    return res;
  }
}
