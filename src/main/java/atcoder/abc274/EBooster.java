package atcoder.abc274;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class EBooster {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n + m][2];
    for (int i = 0; i < n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }
    for (int i = 0; i < m; i++) {
      a[n + i][0] = in.nextInt();
      a[n + i][1] = in.nextInt();
    }
    double[] dis0 = new double[n + m];
    for (int i = 0; i < n + m; i++) {
      dis0[i] = Math.sqrt((long) (a[i][0]) * (a[i][0]) + (long) (a[i][1]) * ((a[i][1])));
    }

    double[][] dis = new double[n + m][n + m];

    for (int i = 0; i < n + m; i++) {
      for (int j = i + 1; j < n + m; j++) {
        dis[i][j] = dis[j][i] = Math.sqrt((long) (a[i][0] - a[j][0]) * (a[i][0] - a[j][0]) + (long) (a[i][1] - a[j][1]) * ((a[i][1] - a[j][1])));
      }
    }

    int[] speed = new int[]{1, 2, 4, 8, 16, 32, 64};

    int x = ((1 << m) - 1) << n;

    double[][] dp = new double[1 << (n + m)][n + m];

    for (int i = 0; i < 1 << (n + m); i++) {
      Arrays.fill(dp[i], Double.MAX_VALUE / 2);
    }

    for (int i = 0; i < n + m; i++) {
      dp[1 << i][i] = dis0[i];
    }

    for (int i = 0; i < (1 << (n + m)); i++) {
      int sp = speed[Integer.bitCount(i & x)];
      for (int j = 0; j < n + m; j++) {
        for (int k = 0; k < n + m; k++) {
          if (j == k) {
            continue;
          }
          if ((i >> j & 1) == 1 && (i >> k & 1) == 1) {
            if (j >= n) {
              dp[i][j] = Math.min(dp[i][j], dp[i ^ (1 << j)][k] + dis[k][j] / (sp / 2));
            } else {
              dp[i][j] = Math.min(dp[i][j], dp[i ^ (1 << j)][k] + dis[k][j] / sp);
            }

          }
        }
      }
    }

    int all = (1 << n) - 1;
    double res = Double.MAX_VALUE / 2;
    for (int i = 0; i < (1 << m); i++) {
      int st = all | (i << n);
      int sp = speed[Integer.bitCount(i)];
      for (int j = 0; j < n + m; j++) {
        if (((st >> j) & 1) == 1) {
          res = Math.min(res, dp[st][j] + dis0[j] / sp);
        }
      }
    }
    out.println(res);

  }
}
