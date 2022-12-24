package nowcoder.courses.dp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }

    int[][] dp1 = new int[n + 1][m + 1];
    int[][] dp2 = new int[n + 2][m + 2];

    dp1[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        dp1[i][j] += dp1[i - 1][j];
        if (j - a[i] >= 0) {
          dp1[i][j] += dp1[i - 1][j - a[i]];
        }
        dp1[i][j] %= 10;
      }
    }

    dp2[n + 1][0] = 1;
    for (int i = n; i > 0; i--) {
      for (int j = 0; j <= m; j++) {
        dp2[i][j] += dp2[i + 1][j];
        if (j - a[i] >= 0) {
          dp2[i][j] += dp2[i + 1][j - a[i]];
        }
        dp2[i][j] %= 10;
      }
    }


    int[][] g = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        for (int l = 0; l <= j; l++) {
          int r = j - l;
          g[i][j] += dp1[i - 1][l] * dp2[i + 1][r];
          g[i][j] %= 10;
        }

      }
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        out.print(g[i][j]);
      }
      out.println();
    }
  }
}
