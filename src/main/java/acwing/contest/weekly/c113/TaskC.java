package acwing.contest.weekly.c113;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class TaskC {
  int n, m, k;


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int mod = (int) (1e9 + 7);
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();

    if (2 * k > n - 1 || 2 * k > m - 1) {
      out.println(0);
      return;
    }
    CombinationMath.initMod(mod);
    out.println(CombinationMath.comb(n - 1, 2 * k) * CombinationMath.comb(m - 1, 2 * k) % mod);

  }
}
