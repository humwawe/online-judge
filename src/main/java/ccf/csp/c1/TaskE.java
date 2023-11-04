package ccf.csp.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskE {
  int N = 50, M = 210, inf = 0x3f3f3f3f;

  int n;
  int[][] c = new int[N][3];
  int[][][][] f = new int[2][M][M][M];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int m = 0;
    int m2 = 0;
    for (int i = 1; i <= n; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      int z = in.nextInt();
      int t = in.nextInt();
      c[i][0] = x;
      c[i][1] = z;
      c[i][2] = Math.min(y, t);
      m += x;
      if (i % 2 == 1) {
        m2 += x;
      }
    }

    m = Math.max(m2, m - m2);


    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k < M; k++) {
          Arrays.fill(f[i][j][k], inf);
        }
      }
    }
    f[0][0][0][0] = 0;

    for (int u = 1; u <= n; u++) {
      for (int i = 0; i <= m; i++) {
        for (int j = i; j <= m; j++) {
          for (int k = 0; k <= m; k++) {
            if (k > j) {
              f[u & 1][i][j][k] = inf;
            } else {
              int x = c[u][0], y = c[u][1], z = c[u][2], t = u - 1 & 1;
              f[u & 1][i][j][k] = f[u - 1 & 1][i][j][k] + z;
              if (i >= x) {
                f[u & 1][i][j][k] = Math.min(f[u & 1][i][j][k], f[t][i - x][j][k]);
              }
              if (j >= x) {
                f[u & 1][i][j][k] = Math.min(f[u & 1][i][j][k], f[t][Math.min(i, j - x)][Math.max(i, j - x)][k]);
              }
              if (i >= y && k >= y) {
                f[u & 1][i][j][k] = Math.min(f[u & 1][i][j][k], f[t][i - y][j][k - y]);
              }
              if (j >= y && k >= y) {
                f[u & 1][i][j][k] = Math.min(f[u & 1][i][j][k], f[t][Math.min(i, j - y)][Math.max(i, j - y)][k - y]);
              }
            }
          }
        }
      }
    }

    int res = inf;
    n &= 1;
    for (int i = 0; i <= m; i++) {
      for (int j = i; j <= m; j++) {
        for (int k = 0; k <= j; k++) {
          res = Math.min(res, f[n][i][j][k] + Math.max(i, j));
        }
      }
    }
    out.println(res);
  }
}
