package nowcoder.r1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  int n;
  int[] a;
  Long[][] memo;
  int mod = (int) (1e9 + 7);

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    n = s.length();
    a = new int[n];
    memo = new Long[n][9];
    for (int i = 0; i < n; i++) {
      a[i] = s.charAt(i) - '0';
    }

    out.println((dfs(0, 0) - 1 + mod) % mod);

  }

  private long dfs(int i, int u) {
    if (i == n) {
      if (u == 0) {
        return 1;
      }
      return 0;
    }

    if (memo[i][u] != null) {
      return memo[i][u];
    }
    long res = dfs(i + 1, u);
    res = (res + dfs(i + 1, (u + a[i]) % 9)) % mod;
    return memo[i][u] = res;
  }
}
