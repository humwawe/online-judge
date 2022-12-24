package nowcoder.courses.dp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  int[] a, b;
  int inf = (int) 1e8;
  Integer[][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    a = new int[n + 1];
    b = new int[n + 2];
    memo = new Integer[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 1; i <= n; i++) {
      b[i] = in.nextInt();
    }


    out.println(dfs(1, n));

  }

  private int dfs(int i, int j) {
    if (i > j) {
      return 0;
    }
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    int res = inf;
    for (int k = i; k <= j; k++) {
      res = Math.min(res, dfs(i, k - 1) + dfs(k + 1, j) + a[k] + b[i - 1] + b[j + 1]);
    }
    return memo[i][j] = res;
  }
}
