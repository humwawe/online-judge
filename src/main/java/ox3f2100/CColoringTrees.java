package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CColoringTrees {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n + 1];
    a[0] = -1;
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    int[][] p = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        p[i][j] = in.nextInt();
      }
    }
    long[][][] dp = new long[n + 1][m + 1][k + 1];
    long inf = (long) 1e15;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        Arrays.fill(dp[i][j], inf);
      }
    }
    if (a[1] == 0) {
      for (int i = 1; i <= m; i++) {
        dp[1][i][1] = p[0][i - 1];
      }
    } else {
      for (int i = 1; i <= m; i++) {
        dp[1][a[1]][1] = 0;
      }
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        for (int l = 1; l <= k; l++) {
          if (a[i] != 0) {
            int t = j == a[i] ? 0 : 1;
            dp[i][a[i]][l] = Math.min(dp[i][a[i]][l], dp[i - 1][j][l - t]);
          } else {
            for (int o = 1; o <= m; o++) {
              int t = j == o ? 0 : 1;
              dp[i][o][l] = Math.min(dp[i][o][l], dp[i - 1][j][l - t] + p[i - 1][o - 1]);
            }
          }
        }
      }
    }
    long res = inf;
    for (int i = 1; i <= m; ++i) {
      res = Math.min(res, dp[n][i][k]);
    }
    if (res == inf) {
      out.println("-1");
      return;
    }
    out.println(res);
  }
}
