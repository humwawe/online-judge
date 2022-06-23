package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DEasyProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    long inf = (long) 1e15;
    long[][] dp = new long[n + 1][5];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], inf);
    }
    for (int i = 1; i <= 4; i++) {
      dp[0][i] = 0;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 4; j++) {
        dp[i][j] = dp[i - 1][j];
      }

      if (s.charAt(i - 1) == 'h') {
        dp[i][1] = dp[i - 1][1] + a[i - 1];
      } else if (s.charAt(i - 1) == 'a') {
        dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2] + a[i - 1]);
      } else if (s.charAt(i - 1) == 'r') {
        dp[i][3] = Math.min(dp[i - 1][2], dp[i - 1][3] + a[i - 1]);
      } else if (s.charAt(i - 1) == 'd') {
        dp[i][4] = Math.min(dp[i - 1][3], dp[i - 1][4] + a[i - 1]);
      }
    }
    out.println(dp[n][4]);
  }

}
