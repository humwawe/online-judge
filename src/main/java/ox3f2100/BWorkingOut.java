package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BWorkingOut {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
      }
    }
    int[][] dp1 = new int[n + 5][m + 5];
    int[][] dp2 = new int[n + 5][m + 5];
    int[][] dp3 = new int[n + 5][m + 5];
    int[][] dp4 = new int[n + 5][m + 5];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        dp1[i][j] = Math.max(dp1[i - 1][j] + a[i - 1][j - 1], dp1[i][j - 1] + a[i - 1][j - 1]);
      }
    }
    for (int i = n; i >= 1; i--) {
      for (int j = 1; j <= m; j++) {
        dp2[i][j] = Math.max(dp2[i + 1][j] + a[i - 1][j - 1], dp2[i][j - 1] + a[i - 1][j - 1]);
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = m; j >= 1; j--) {
        dp3[i][j] = Math.max(dp3[i - 1][j] + a[i - 1][j - 1], dp3[i][j + 1] + a[i - 1][j - 1]);
      }
    }
    for (int i = n; i >= 1; i--) {
      for (int j = m; j >= 1; j--) {
        dp4[i][j] = Math.max(dp4[i + 1][j] + a[i - 1][j - 1], dp4[i][j + 1] + a[i - 1][j - 1]);
      }
    }
    int res = 0;
    for (int i = 2; i < n; i++) {
      for (int j = 2; j < m; j++) {
        res = Math.max(res, Math.max(dp2[i + 1][j] + dp3[i - 1][j] + dp1[i][j - 1] + dp4[i][j + 1], dp2[i][j - 1] + dp3[i][j + 1] + dp1[i - 1][j] + dp4[i + 1][j]));
      }
    }
    out.println(res);
  }
}
