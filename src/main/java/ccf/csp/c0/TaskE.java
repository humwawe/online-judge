package ccf.csp.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskE {
  int n, m;
  char[][] mat;
  boolean[][] vis1, vis2;
  int[][] fs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    mat = new char[n][m];
    vis1 = new boolean[n][m];
    vis2 = new boolean[n][m];

    int si = 0;
    int sj = 0;
    int ti = 0;
    int tj = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = in.nextCharacter();
        if (mat[i][j] == 'S') {
          si = i;
          sj = j;
        }
        if (mat[i][j] == 'T') {
          ti = i;
          tj = j;
        }
      }
    }

    dfs1(si, sj);
    if (!vis1[ti][tj]) {
      out.println("I'm stuck!");
      return;
    }

    dfs2(ti, tj);
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (vis1[i][j] && !vis2[i][j]) {
          res++;
        }
      }
    }
    out.println(res);

  }

  private void dfs2(int x, int y) {
    vis2[x][y] = true;
    for (int i = 0; i < fs.length; i++) {
      int nx = x + fs[i][0];
      int ny = y + fs[i][1];
      if (nx >= 0 && nx < n && ny >= 0 && ny < m && mat[nx][ny] != '#' && !vis2[nx][ny]) {
        if (check(nx, ny, i ^ 2)) {
          dfs2(nx, ny);
        }
      }
    }
  }

  private void dfs1(int x, int y) {
    vis1[x][y] = true;
    for (int i = 0; i < fs.length; i++) {
      int nx = x + fs[i][0];
      int ny = y + fs[i][1];
      if (nx >= 0 && nx < n && ny >= 0 && ny < m && mat[nx][ny] != '#' && !vis1[nx][ny]) {
        if (check(x, y, i)) {
          dfs1(nx, ny);
        }
      }
    }
  }

  private boolean check(int x, int y, int i) {
    if (mat[x][y] == 'S' || mat[x][y] == 'T' || mat[x][y] == '+') {
      return true;
    }
    if (mat[x][y] == '|' && i % 2 == 0) {
      return true;
    }
    if (mat[x][y] == '-' && i % 2 == 1) {
      return true;
    }
    if (mat[x][y] == '.' && i == 2) {
      return true;
    }
    return false;
  }
}
