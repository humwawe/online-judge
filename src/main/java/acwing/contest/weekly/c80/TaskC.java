package acwing.contest.weekly.c80;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  int n1, n2, k1, k2;
  int mod = (int) 1e8;
  Integer[][][][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n1 = in.nextInt();
    n2 = in.nextInt();
    k1 = in.nextInt();
    k2 = in.nextInt();
    memo = new Integer[n1 + 1][n2 + 1][k1 + 1][k2 + 1];
    out.println(dfs(n1, n2, k1, k2));
  }

  private long dfs(int n1, int n2, int c1, int c2) {
    if (n1 == 0 && n2 == 0) {
      return 1;
    }
    if (memo[n1][n2][c1][c2] != null) {
      return memo[n1][n2][c1][c2];
    }
    int res = 0;
    if (n1 > 0 && c1 > 0) {
      res += dfs(n1 - 1, n2, c1 - 1, k2);
      res %= mod;
    }
    if (n2 > 0 && c2 > 0) {
      res += dfs(n1, n2 - 1, k1, c2 - 1);
      res %= mod;
    }
    return memo[n1][n2][c1][c2] = res;
  }
}
