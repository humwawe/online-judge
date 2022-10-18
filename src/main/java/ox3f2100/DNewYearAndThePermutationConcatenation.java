package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DNewYearAndThePermutationConcatenation {
  int mod = 998244353;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    long res = util.CombinationMath.fact(n);
    for (int i = 1; i <= n - 1; i++) {
      res = add(res, mul(sub(util.CombinationMath.perm(n, i), util.CombinationMath.comb(n, i)), util.CombinationMath.perm(n - i, n - i)));
    }
    out.println(res);
  }

  private long mul(long a, long b) {
    return a * b % mod;
  }

  long sub(long a, long b) {
    long t = a - b;
    if (t < 0) {
      t += mod;
    }
    return t;

  }

  long add(long a, long b) {
    long t = a + b;
    if (t >= mod) {
      t -= mod;
    }
    return t;
  }

}
