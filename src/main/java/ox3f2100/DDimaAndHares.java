package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DDimaAndHares {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[3][n + 1];

    for (int i = 0; i < 3; i++) {
      for (int j = 1; j <= n; j++) {
        a[i][j] = in.nextInt();
      }
    }
    int[][][] dp = new int[n + 1][3][3];

    int inf = (int) 1e9;
    dp[1][0][0] = a[0][1];
    dp[1][1][1] = a[1][1];
    dp[1][1][0] = dp[1][2][0] = -inf;


    for (int i = 2; i <= n; i++) {

      dp[i][0][0] = Math.max(dp[i - 1][1][1] + a[0][i], dp[i - 1][2][0] + a[0][i]);
      dp[i][1][0] = Math.max(dp[i - 1][0][0] + a[1][i], dp[i - 1][1][0] + a[1][i]);
      dp[i][1][1] = Math.max(dp[i - 1][1][1] + a[1][i], dp[i - 1][2][0] + a[1][i]);
      dp[i][2][0] = Math.max(dp[i - 1][1][0] + a[2][i], dp[i - 1][0][0] + a[2][i]);
    }
    out.println(Math.max(dp[n][0][0], dp[n][1][0]));
  }
}
