package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DBicolorings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    if (k == 1) {
      out.println(2);
      return;
    }
    int mod = 998244353;
    int[][][] dp = new int[n][k + 1][4];
    dp[0][1][0] = 1;
    dp[0][2][1] = 1;
    dp[0][2][2] = 1;
    dp[0][1][3] = 1;

    for (int i = 1; i < n; i++) {
      for (int prev = 0; prev < 4; prev++) {
        for (int cur = 0; cur < 4; cur++) {
          int t = 0;
          if (prev == 0 || prev == 3) {
            if (prev == cur) {
              t = 0;
            } else {
              t = 1;
            }
          } else {
            if ((cur ^ prev) == 3) {
              t = 2;
            } else {
              t = 0;
            }
          }

          for (int j = 0; j <= k; j++) {
            if (j - t >= 0) {
              dp[i][j][cur] = (dp[i][j][cur] + dp[i - 1][j - t][prev]) % mod;
            }
          }
        }
      }
    }

    int res = 0;
    for (int i = 0; i < 4; i++) {
      res += dp[n - 1][k][i];
      res %= mod;
    }
    out.println(res);

  }
}
