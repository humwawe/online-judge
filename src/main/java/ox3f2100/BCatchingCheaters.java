package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BCatchingCheaters {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    String s = in.nextString();
    String t = in.nextString();
    int[][] dp = new int[n + 1][m + 1];
    int res = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 2;
          res = Math.max(res, dp[i][j]);
        } else {
          dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] - 1);
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] - 1);
        }
      }
    }
    out.println(res);
  }
}
