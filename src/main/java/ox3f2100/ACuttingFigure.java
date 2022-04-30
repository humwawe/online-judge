package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ACuttingFigure {
  int n, m;
  boolean[][] vis;
  char[][] a;
  int[][] fs = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    a = new char[n][m];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
        if (a[i][j] == '#') {
          cnt++;
        }
      }
    }
    if (cnt < 3) {
      out.println(-1);
      return;
    }


    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == '#') {
          vis = new boolean[n][m];
          vis[i][j] = true;
          int tmp = 0;
          for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
              if (a[k][l] == '#' && !vis[k][l]) {
                dfs(k, l);
                tmp++;
              }
            }
          }
          if (tmp >= 2) {
            out.println(1);
            return;
          }
        }
      }
    }
    out.println(2);
  }

  private void dfs(int i, int j) {
    vis[i][j] = true;
    for (int[] f : fs) {
      int x = f[0] + i;
      int y = f[1] + j;
      if (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && a[x][y] == '#') {
        dfs(x, y);
      }
    }
  }
}
