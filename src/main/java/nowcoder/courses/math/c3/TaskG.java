package nowcoder.courses.math.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class TaskG {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long m = in.nextInt();
    int mod = 998244353;
    CombinationMath.initMod(mod);
    long res = (n - 2) * CombinationMath.comb(m, n - 1) % mod;
    long tmp = 0;
    for (int i = 0; i <= n - 3; i++) {
      tmp = (tmp + CombinationMath.comb(n - 3, i)) % mod;
    }
    out.println(res * tmp % mod);
  }
}
