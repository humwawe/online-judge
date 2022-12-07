package nowcoder.courses.math.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int mod = 998244353;
    CombinationMath.initMod(mod);
    long t1 = 0;
    for (int i = 0; i <= Math.min(a, b); i++) {
      t1 += CombinationMath.comb(a, i) * CombinationMath.comb(b, i) % mod * CombinationMath.fact(i) % mod;
      t1 %= mod;
    }
    long t2 = 0;
    for (int i = 0; i <= Math.min(a, c); i++) {
      t2 += CombinationMath.comb(a, i) * CombinationMath.comb(c, i) % mod * CombinationMath.fact(i) % mod;
      t2 %= mod;
    }
    long t3 = 0;
    for (int i = 0; i <= Math.min(b, c); i++) {
      t3 += CombinationMath.comb(b, i) * CombinationMath.comb(c, i) % mod * CombinationMath.fact(i) % mod;
      t3 %= mod;
    }
    out.println(t1 * t2 % mod * t3 % mod);
  }
}
