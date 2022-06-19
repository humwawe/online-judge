package codeforces.c801;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CZeroPath {
  public void solve(int testNumber, InputReader in, OutputWriter out) {

    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
      }
    }
    if ((n + m - 1) % 2 != 0) {
      out.println("NO");
      return;
    }
    int[][][] dp = new int[n][m][2];
    dp[0][0][0] = a[0][0];
    dp[0][0][1] = a[0][0];
    for (int i = 1; i < n; i++) {
      dp[i][0][0] = dp[i - 1][0][0] + a[i][0];
      dp[i][0][1] = dp[i - 1][0][1] + a[i][0];

    }
    for (int i = 1; i < m; i++) {
      dp[0][i][0] = dp[0][i - 1][0] + a[0][i];
      dp[0][i][1] = dp[0][i - 1][1] + a[0][i];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        dp[i][j][0] = Math.min(dp[i - 1][j][0], dp[i][j - 1][0]) + a[i][j];
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + a[i][j];
      }
    }
    if (dp[n - 1][m - 1][0] <= 0 && 0 <= dp[n - 1][m - 1][1]) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }

}
