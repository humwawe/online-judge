package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;


public class DIgorInTheMuseum {
  char[][] a;
  int[][] p;
  int n, m;
  int[][] fs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    int k = in.nextInt();
    a = new char[n][m];
    p = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == '.') {
          int fa = i * m + j;
          dfs(i, j, fa);
        }
      }
    }
    int[] cnt = new int[n * m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == '*') {
          for (int[] f : fs) {
            int x = f[0] + i;
            int y = f[1] + j;
            if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] == 'x') {
              cnt[p[x][y]]++;
            }
          }
        }
      }
    }
    for (int i = 0; i < k; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      out.println(cnt[p[x][y]]);
    }

  }

  private void dfs(int i, int j, int fa) {
    a[i][j] = 'x';
    p[i][j] = fa;
    for (int[] f : fs) {
      int x = f[0] + i;
      int y = f[1] + j;
      if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] == '.') {
        dfs(x, y, fa);
      }
    }

  }
}
