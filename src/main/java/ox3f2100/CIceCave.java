package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CIceCave {
  int n, m;
  char[][] a;
  int[][] cnt;
  int x1, x2, y1, y2;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    a = new char[n][m];
    cnt = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
        if (a[i][j] == 'X') {
          cnt[i][j] = 1;
        }
      }
    }
    x1 = in.nextInt() - 1;
    y1 = in.nextInt() - 1;
    x2 = in.nextInt() - 1;
    y2 = in.nextInt() - 1;
    if (dfs(x1, y1)) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }

  int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private boolean dfs(int x1, int y1) {
    for (int[] f : fs) {
      int nx = x1 + f[0];
      int ny = y1 + f[1];
      if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
        if (cnt[nx][ny] == 1) {
          if (nx == x2 && ny == y2) {
            return true;
          }
        } else {
          cnt[nx][ny] = 1;
          if (dfs(nx, ny)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
