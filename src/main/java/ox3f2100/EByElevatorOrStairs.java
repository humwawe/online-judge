package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class EByElevatorOrStairs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int c = in.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n - 1; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < n - 1; i++) {
      b[i] = in.nextInt();
    }
    int[][] dp = new int[n][2];
    int inf = (int) 1e9;
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], inf);
    }
    dp[0][0] = 0;
    int[] res = new int[n];
    res[0] = 0;
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.min(dp[i][0], dp[i - 1][0] + a[i - 1]);
      dp[i][0] = Math.min(dp[i][0], dp[i - 1][1] + a[i - 1]);

      dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + b[i - 1] + c);
      dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + b[i - 1]);

      res[i] = Math.min(dp[i][0], dp[i][1]);

    }
    out.println(res);

  }
}
