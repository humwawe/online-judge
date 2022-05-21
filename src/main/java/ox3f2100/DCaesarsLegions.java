package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DCaesarsLegions {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int k1 = in.nextInt();
    int k2 = in.nextInt();
    int k = Math.max(k1, k2);
    int[][][] dp = new int[n1 + 1][n2 + 1][2];

    int mod = (int) (1e8);
    dp[0][0][1] = 1;
    dp[0][0][0] = 1;


    for (int i = 0; i <= n1; i++) {
      for (int j = 0; j <= n2; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        for (int l = 1; l <= k1; l++) {
          if (i - l >= 0) {
            dp[i][j][0] += dp[i - l][j][1];
            dp[i][j][0] %= mod;
          }
        }

        for (int l = 1; l <= k2; l++) {
          if (j - l >= 0) {
            dp[i][j][1] += dp[i][j - l][0];
            dp[i][j][1] %= mod;
          }
        }

      }
    }

    int res = 0;
    res += dp[n1][n2][0];
    res %= mod;
    res += dp[n1][n2][1];
    res %= mod;

    out.println(res);
  }
}
