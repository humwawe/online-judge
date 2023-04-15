package atcoder.abc298;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

public class EUnfairSugoroku {
  int n, a, b;
  long np, nq, p, q;
  int mod = 998244353;
  Long[][][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    CombinationMath.initMod(mod);
    n = in.nextInt();
    a = in.nextInt();
    b = in.nextInt();
    p = in.nextInt();
    q = in.nextInt();
    memo = new Long[200][200][2];
    np = CombinationMath.inv(p);
    nq = CombinationMath.inv(q);

    out.println(dfs(a, b, 0));

  }

  private long dfs(int i, int j, int turn) {
    if (memo[i][j][turn] != null) {
      return memo[i][j][turn];
    }
    if (i >= n) {
      return 1;
    }

    if (j >= n) {
      return 0;
    }
    long res = 0;
    if (turn == 0) {
      for (int k = 1; k <= p; k++) {
        res = (res + np * dfs(i + k, j, 1 - turn) % mod) % mod;
      }
    } else {
      for (int k = 1; k <= q; k++) {
        res = (res + nq * dfs(i, j + k, 1 - turn) % mod) % mod;
      }
    }
    return memo[i][j][turn] = res;

  }
}
