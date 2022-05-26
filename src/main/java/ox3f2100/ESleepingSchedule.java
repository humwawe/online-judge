package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class ESleepingSchedule {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int h = in.nextInt();
    int l = in.nextInt();
    int r = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }

    int[][] dp = new int[n + 1][h];

    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dp[i], -1);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < h; j++) {
        int t = (j - a[i] + h) % h;
        if (dp[i - 1][t] >= 0) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][t] + (j >= l && j <= r ? 1 : 0));
        }
        t = (j - (a[i] - 1) + h) % h;
        if (dp[i - 1][t] >= 0) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][t] + (j >= l && j <= r ? 1 : 0));
        }
      }
    }
    int max = 0;
    for (int i = 0; i < h; i++) {
      max = Math.max(max, dp[n][i]);
    }
    out.println(max);
  }
}
