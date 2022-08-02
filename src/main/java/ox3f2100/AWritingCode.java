package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AWritingCode {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int b = in.nextInt();
    int mod = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int[][][] dp = new int[n + 1][m + 1][b + 1];
    dp[0][0][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        for (int k = 0; k <= b; k++) {
          dp[i][j][k] = dp[i - 1][j][k];
          if (j >= 1 && k >= a[i - 1]) {
            dp[i][j][k] = (dp[i][j][k] + dp[i][j - 1][k - a[i - 1]]) % mod;
          }
        }
      }
    }


    int res = 0;
    for (int i = 0; i <= b; i++) {
      res += dp[n][m][i];
      res %= mod;
    }
    out.println(res);
  }
}
