package acwing.contest.weekly.c114;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  int n, m;
  Double[][][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    memo = new Double[n + 1][m + 1][3];
    out.println(dfs(n, m, 0));
  }

  private double dfs(int n, int m, int turn) {

    double res = 0;
    turn %= 3;

    if (memo[n][m][turn] != null) {
      return memo[n][m][turn];
    }
    if (turn == 0) {
      if (n == 0) {
        return 0;
      }
      if (m == 0) {
        return 1;
      }
      res += (double) n / (n + m);
      res += (double) m / (n + m) * dfs(n, m - 1, turn + 1);
    } else if (turn == 1) {
      if (m == 0) {
        return 0;
      }
      res += (double) m / (n + m) * dfs(n, m - 1, turn + 1);
    } else {
      if (n + m == 1) {
        return 0;
      }
      if (m - 1 >= 0) {
        res += (double) m / (n + m) * dfs(n, m - 1, turn + 1);
      }
      if (n - 1 >= 0) {
        res += (double) n / (n + m) * dfs(n - 1, m, turn + 1);
      }
    }
    return memo[n][m][turn] = res;
  }
}
