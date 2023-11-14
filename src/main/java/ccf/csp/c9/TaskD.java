package ccf.csp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  int n;
  int[] a, sum;
  int inf = (int) 1e9;
  Integer[][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = in.nextInt(n);
    memo = new Integer[n][n];
    sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + a[i];
    }
    out.println(dfs(0, n - 1));
  }

  private int dfs(int i, int j) {
    if (i == j) {
      return 0;
    }

    if (memo[i][j] != null) {
      return memo[i][j];
    }
    int res = inf;
    for (int k = i; k < j; k++) {
      res = Math.min(res, dfs(i, k) + dfs(k + 1, j) + sum[j + 1] - sum[i]);
    }
    return memo[i][j] = res;
  }
}
