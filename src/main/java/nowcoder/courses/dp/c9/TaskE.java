package nowcoder.courses.dp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    boolean[][] vis = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      int k = in.nextInt();
      for (int j = 0; j < k; j++) {
        int x = in.nextInt() - 1;
        vis[i][x] = true;
      }
    }
    int mod = (int) (1e9 + 7);
    long res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {

          long[][] dp = new long[m + 1][8];
          dp[0][0] = 1;

          for (int l = 1; l <= m; l++) {
            for (int st = 0; st < 8; st++) {
              dp[l][st] = dp[l - 1][st];
              int t = st;
              if (vis[l - 1][i]) {
                t ^= 1;
              }
              if (vis[l - 1][j]) {
                t ^= 1 << 1;
              }
              if (vis[l - 1][k]) {
                t ^= 1 << 2;
              }
              dp[l][st] += dp[l - 1][t];
              dp[l][st] %= mod;
            }
          }
          res = (res + dp[m][7]) % mod;
        }
      }
    }
    out.println(res);

  }
}
