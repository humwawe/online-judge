package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AMulticoloredMarbles {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] dp = new int[2][n + 1];
    int mod = (int) (1e9 + 7);

    for (int i = 1; i <= n; i++) {
      dp[0][i] = dp[0][i - 1];
      dp[1][i] = dp[1][i - 1];

      if (i % 2 == 0) {
        dp[0][i] += 1;
        dp[0][i] += dp[1][i - 1];
        dp[0][i] %= mod;
      } else {
        dp[1][i] += 1;
        dp[1][i] += dp[0][i - 1];
        dp[1][i] %= mod;
      }
    }
    out.println((dp[0][n] + dp[1][n]) % mod);
  }
}
