package codeforces.c841;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class BKillDemodogs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    //n(n+1)(2n+1)/6
    int mod = (int) (1e9 + 7);
    CombinationMath.initMod(mod);
    long sum1 = n * (n + 1) % mod * (2 * n + 1) % mod * CombinationMath.inv(6) % mod;
    //n(n+1)(n+2)/3
    long sum2 = n * (n + 1) % mod * (n + 2) % mod * CombinationMath.inv(3) % mod;
    long sum = ((sum1 + sum2 - n * (n + 1) % mod) % mod + mod) % mod;
    out.println(2022 * sum % mod);

  }
}
