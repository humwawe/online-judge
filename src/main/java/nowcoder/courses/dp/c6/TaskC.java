package nowcoder.courses.dp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  int[] a;
  int n;
  Double[] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = in.nextInt(n);
    memo = new Double[n];
    out.println(dfs(0));
  }

  private double dfs(int u) {

    if (u == n - 1) {
      return a[u];
    }
    if (memo[u] != null) {
      return memo[u];
    }
    double res = 0;
    int cnt = 0;
    for (int i = 1; i <= 6; i++) {
      if (u + i < n) {
        res += 1.0 / 6 * dfs(u + i);
      } else {
        cnt++;
      }
    }
    res = res * 6.0 / (6 - cnt) + a[u];
    return memo[u] = res;
  }
}
