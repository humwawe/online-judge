package acwing.contest.weekly.c96;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[m + 2][4];
    a[1][0] = in.nextInt();
    a[1][1] = in.nextInt();
    for (int i = 2; i <= m + 1; i++) {
      a[i][3] = in.nextInt();
      a[i][2] = in.nextInt();
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }

    int[][] dp = new int[m + 2][n + 1];


    for (int i = 1; i <= m + 1; i++) {
      int cnt = 1005;
      if (i != 1) {
        cnt = a[i][3] / a[i][2];
      }
      for (int j = 0; j <= cnt; j++) {
        for (int k = 0; k <= n; k++) {
          if (k - j * a[i][0] >= 0) {
            dp[i][k] = Math.max(dp[i][k], dp[i - 1][k - j * a[i][0]] + j * a[i][1]);
          }
        }
      }
    }
    int max = 0;
    for (int i = 0; i <= n; i++) {
      max = Math.max(max, dp[m + 1][i]);
    }
    out.println(max);
  }
}
