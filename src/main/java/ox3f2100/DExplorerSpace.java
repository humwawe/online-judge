package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DExplorerSpace {
  int n, m, k;
  int[][] a, b;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();

    a = new int[n][m - 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m - 1; j++) {
        a[i][j] = in.nextInt();
      }
    }
    b = new int[n - 1][m];
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < m; j++) {
        b[i][j] = in.nextInt();
      }
    }

    if (k % 2 != 0) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          out.print(-1, "");
        }
        out.println();
      }
      return;
    }

    int inf = (int) 1e8;
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][][] dist = new int[n][m][k + 1];

    for (int l = 0; l < n; l++) {
      for (int o = 0; o < m; o++) {
        Arrays.fill(dist[l][o], inf);
      }
    }

    for (int l = 0; l < n; l++) {
      for (int o = 0; o < m; o++) {
        dist[l][o][0] = 0;
      }
    }
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        queue.add(new int[]{i, j});
      }
    }

    for (int l = 1; l <= k / 2; l++) {
      while (!queue.isEmpty()) {
        int[] poll = queue.poll();
        for (int[] f : fs) {
          int x = poll[0] + f[0];
          int y = poll[1] + f[1];
          if (x >= 0 && x < n && y >= 0 && y < m) {
            if (x == poll[0]) {
              int minY = Math.min(y, poll[1]);
              int d = a[x][minY];
              dist[x][y][l] = Math.min(dist[x][y][l], dist[poll[0]][poll[1]][l - 1] + d);
            } else {
              int minX = Math.min(x, poll[0]);
              int d = b[minX][y];
              dist[x][y][l] = Math.min(dist[x][y][l], dist[poll[0]][poll[1]][l - 1] + d);
            }
          }
        }
      }
      for (int o = 0; o < n; o++) {
        for (int p = 0; p < m; p++) {
          queue.add(new int[]{o, p});
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        out.print(dist[i][j][k / 2] * 2, "");
      }
      out.println();
    }
  }

}
