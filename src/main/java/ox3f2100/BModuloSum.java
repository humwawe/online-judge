package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BModuloSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    if (n >= m) {
      out.println("YES");
      return;
    }
    boolean[][] dp = new boolean[n + 1][m];

    for (int i = 1; i <= n; i++) {
      int x = in.nextInt() % m;
      dp[i][x] = true;
      for (int j = 0; j < m; j++) {
        if (dp[i - 1][j]) {
          dp[i][j] = true;
          dp[i][(j + x) % m] = true;
        }
      }
    }
    if (dp[n][0]) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}
