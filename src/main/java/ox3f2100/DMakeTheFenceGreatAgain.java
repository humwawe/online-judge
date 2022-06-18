package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DMakeTheFenceGreatAgain {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      b[i] = in.nextInt();
    }
    long inf = (long) (1e18 + 5);

    long[][] dp = new long[n + 1][3];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], inf);
    }
    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[0][2] = 0;
    int last = -10;
    for (int i = 1; i <= n; i++) {
      int cur = a[i - 1];
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          if (cur + j != last + k) {
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + j * b[i - 1]);
          }
        }
      }
      last = cur;
    }
    long res = inf;
    for (int i = 0; i < 3; i++) {
      res = Math.min(res, dp[n][i]);
    }
    out.println(res);
  }
}
