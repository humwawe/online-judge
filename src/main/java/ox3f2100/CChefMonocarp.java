package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CChefMonocarp {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    int[][] dp = new int[n + 1][405];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dp[i], (int) 1e9);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 400; j++) {
        for (int k = 0; k < j; k++) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - a[i - 1]));
        }
      }
    }
    int min = (int) 1e9;
    for (int i = 1; i <= 400; i++) {
      min = Math.min(min, dp[n][i]);
    }
    out.println(min);
  }
}
