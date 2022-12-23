package nowcoder.courses.dp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int s = in.nextInt();
    int n = in.nextInt();
    double[][] dp = new double[s + 2][n + 2];

    for (int i = s; i >= 0; i--) {
      for (int j = n; j >= 0; j--) {
        if (i == s && j == n) {
          continue;
        }
        double x = i, y = j;
        dp[i][j] = ((double) x * y / (s * n)
            + x / s * (1 - y / n) * (dp[i][j + 1] + 1)
            + (1 - x / s) * (y / n) * (dp[i + 1][j] + 1)
            + (1 - x / s) * (1 - y / n) * (dp[i + 1][j + 1] + 1)) / (1 - x * y / (s * n));
      }
    }
    out.println(dp[0][0]);

  }
}
