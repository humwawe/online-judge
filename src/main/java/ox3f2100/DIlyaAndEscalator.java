package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DIlyaAndEscalator {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    double p = in.nextDouble();
    int t = in.nextInt();
    double res = 0;
    double[][] dp = new double[n + 1][t + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= t; j++) {
        dp[i][j] = p * (dp[i - 1][j - 1] + 1) + (1 - p) * dp[i][j - 1];
      }
    }
    out.println(dp[n][t]);
  }
}
