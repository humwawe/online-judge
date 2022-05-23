package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CGeorgeAndJob {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    long[] sum = new long[n + 1];
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum[i + 1] = sum[i] + a[i];
    }
    long[][] dp = new long[n + 1][k + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        dp[i][j] = dp[i - 1][j];
        if (i >= m && j >= 1) {
          dp[i][j] = Math.max(dp[i][j], dp[i - m][j - 1] + sum[i] - sum[i - m]);
        }
      }
    }
    out.println(dp[n][k]);
  }
}
