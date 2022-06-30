package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DKefaAndDishes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int lim = 1 << n;
    long[][] dp = new long[lim][n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      dp[1 << i][i] = a[i];
    }
    int[][] c = new int[n][n];
    for (int i = 0; i < k; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      c[x][y] = in.nextInt();
    }


    long res = 0;
    for (int i = 0; i < lim; i++) {
      for (int j = 0; j < n; j++) {
        if ((i >> j & 1) == 0) {
          for (int l = 0; l < n; l++) {
            if ((i >> l & 1) == 1) {
              dp[i | (1 << j)][j] = Math.max(dp[i | (1 << j)][j], dp[i][l] + c[l][j] + a[j]);
            }
          }
          if (Integer.bitCount(i) == m - 1) {
            res = Math.max(res, dp[i | (1 << j)][j]);
          }
        }
      }
    }
    out.println(res);
  }
}
