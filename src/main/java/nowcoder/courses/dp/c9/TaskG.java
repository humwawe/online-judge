package nowcoder.courses.dp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskG {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String a = in.nextString();
    String b = in.nextString();
    int n = a.length();
    int m = b.length();
    int[][] dp = new int[n][m];
    int[][] cnt = new int[n][m];
    for (int i = 0; i < n; i++) {
      cnt[i][0] = 1;
    }
    for (int i = 0; i < m; i++) {
      cnt[0][i] = 1;
    }
    int mod = 100000000;
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        char x = a.charAt(i - 1);
        char y = b.charAt(j - 1);

        if (x == y) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          cnt[i][j] = cnt[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }

        if (dp[i][j] == dp[i][j - 1]) {
          cnt[i][j] += cnt[i][j - 1];
        }
        if (dp[i][j] == dp[i - 1][j]) {
          cnt[i][j] += cnt[i - 1][j];
        }
        if (dp[i][j] == dp[i - 1][j - 1]) {
          cnt[i][j] -= cnt[i - 1][j - 1];
        }
        cnt[i][j] %= mod;
      }
    }
    out.println(dp[n - 1][m - 1]);
    out.println(cnt[n - 1][m - 1]);
  }
}
