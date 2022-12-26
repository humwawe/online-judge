package nowcoder.courses.dp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    String a = in.nextString();
    String b = in.nextString();
    int[][][] dp = new int[n + 1][m + 1][n + 1];
    int mod = 1024523;
    dp[0][0][0] = 1;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        for (int k = 0; k <= n; k++) {
          int l = i + j - k;
          if (i - 1 >= 0 && k - 1 >= 0 && a.charAt(i - 1) == a.charAt(k - 1)) {
            dp[i][j][k] += dp[i - 1][j][k - 1];
          }
          if (i - 1 >= 0 && l - 1 >= 0 && l - 1 < m && a.charAt(i - 1) == b.charAt(l - 1)) {
            dp[i][j][k] += dp[i - 1][j][k];
          }
          if (j - 1 >= 0 && k - 1 >= 0 && b.charAt(j - 1) == a.charAt(k - 1)) {
            dp[i][j][k] += dp[i][j - 1][k - 1];
          }
          if (j - 1 >= 0 && l - 1 >= 0 && l - 1 < m && b.charAt(j - 1) == b.charAt(l - 1)) {
            dp[i][j][k] += dp[i][j - 1][k];
          }
          dp[i][j][k] %= mod;
        }
      }
    }
    out.println(dp[n][m][n]);
  }
}
