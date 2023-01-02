package nowcoder.courses.dp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskI {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int t = in.nextInt();
    String[] ss = new String[n];
    for (int i = 0; i < n; i++) {
      ss[i] = in.nextString();
    }

    int[][] a = new int[n][m + 1];
    for (int i = 0; i < n; i++) {
      String s = ss[i];
      int[][] dp = new int[m + 1][m + 1];
      for (int j = 1; j <= m; j++) {
        for (int k = 1; k <= m; k++) {
          int cnt0 = 0;
          int cnt1 = 0;
          for (int l = j; l >= 1; l--) {
            if (s.charAt(l - 1) == '1') {
              cnt1++;
            } else {
              cnt0++;
            }
            dp[j][k] = Math.max(dp[j][k], dp[l - 1][k - 1] + Math.max(cnt0, cnt1));
          }
        }
      }
      System.arraycopy(dp[m], 1, a[i], 1, m);
    }

    int[][] dp = new int[n + 1][t + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= t; j++) {
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
        for (int k = 1; k <= j && k <= m; k++) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + a[i - 1][k]);
        }
      }
    }


    out.println(dp[n][t]);

  }
}
