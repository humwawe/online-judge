package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class AGarland {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] cnt = new int[2];
    cnt[0] = n / 2;
    cnt[1] = n - cnt[0];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();

    }
    int[][][][] dp = new int[n + 1][n + 1][n + 1][2];
    int inf = (int) 1e9;
    for (int i = 0; i < n + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        for (int k = 0; k < n + 1; k++) {
          Arrays.fill(dp[i][j][k], inf);
        }
      }
    }
    dp[0][0][0][0] = dp[0][0][0][1] = 0;

    for (int i = 1; i <= n; i++) {
      if (a[i - 1] == 0 || a[i - 1] % 2 == 1) {
        for (int j = 0; j < i; j++) {
          int k = i - j;
          dp[i][j][k][1] = Math.min(dp[i - 1][j][k - 1][1], dp[i - 1][j][k - 1][0] + 1);
        }
      }

      if (a[i - 1] == 0 || a[i - 1] % 2 == 0) {
        for (int j = 1; j <= i; j++) {
          int k = i - j;
          dp[i][j][k][0] = Math.min(dp[i - 1][j - 1][k][0], dp[i - 1][j - 1][k][1] + 1);
        }
      }
    }
    out.println(Math.min(dp[n][cnt[0]][cnt[1]][0], dp[n][cnt[0]][cnt[1]][1]));
  }
}
