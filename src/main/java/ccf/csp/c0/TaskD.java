package ccf.csp.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] dp = new int[n + 1][1 << 4];
    dp[0][0] = 1;
    int mod = (int) (1e9 + 7);
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 1 << 4; j++) {
        for (int k = 0; k < 4; k++) {
          if (i == 1 && k == 0) {
            continue;
          }
          if (k == 0 && (j >> 1 & 1) == 1) {
            continue;
          }
          if (k == 2 && (j >> 3 & 1) == 1) {
            continue;
          }
          dp[i][j | (1 << k)] = (dp[i][j | (1 << k)] + dp[i - 1][j]) % mod;
        }
      }
    }

    out.println(dp[n][(1 << 4) - 1]);
  }
}
