package nowcoder.courses.dp.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int k = in.nextInt();
    int lim = 1 << n;
    long[][][] dp = new long[n + 1][k + 1][lim];

    dp[0][0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < lim; j++) {
        if (check(j)) {
          continue;
        }
        int t = Integer.bitCount(j);
        for (int l = t; l <= k; l++) {
          for (int m = 0; m < lim; m++) {
            if (check(m, j)) {
              dp[i][l][j] += dp[i - 1][l - t][m];
            }
          }
        }
      }
    }
    long res = 0;
    for (int i = 0; i < lim; i++) {
      res += dp[n][k][i];
    }

    out.println(res);
  }

  private boolean check(int j) {
    for (int i = 0; i < n - 1; i++) {
      if ((j >> i & 1) == 1 && (j >> (i + 1) & 1) == 1) {
        return true;
      }
    }
    return false;
  }

  private boolean check(int l, int m) {
    for (int i = 0; i < n; i++) {
      for (int j = i - 1; j <= i + 1; j++) {
        if ((l >> i & 1) == 1 && j >= 0 && j <= n - 1 && (m >> j & 1) == 1) {
          return false;
        }
      }
    }
    return true;
  }


}
