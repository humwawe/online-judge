package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DBeautifulArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long x = in.nextInt();
    int[] a = in.nextInt(n);
    long[][] dp = new long[n + 1][3];
    for (int i = 1; i <= n; i++) {
      int t = a[i - 1];
      dp[i][0] = Math.max(0, dp[i - 1][0] + t);
      dp[i][1] = Math.max(dp[i][0], dp[i - 1][1] + x * t);
      dp[i][2] = Math.max(dp[i][1], dp[i - 1][2] + t);
    }
    long res = 0;
    for (int i = 1; i <= n; i++) {
      res = Math.max(res, dp[i][2]);
    }
    out.println(res);
  }
}
