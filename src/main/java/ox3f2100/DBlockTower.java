package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DBlockTower {
  int N = 505;
  int[][] g = new int[N][N];
  int n, m;
  int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  char[] res1 = new char[N * N * 3];
  int[] res2 = new int[N * N * 3];
  int[] res3 = new int[N * N * 3];
  int idx = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char x = in.nextCharacter();
        if (x == '.') {
          g[i][j] = 1;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (g[i][j] == 1) {
          dfs(i, j, true);
        }
      }
    }

    out.println(idx);
    for (int i = 0; i < idx; i++) {
      out.println(res1[i], res2[i] + 1, res3[i] + 1);
    }

  }

  private void dfs(int i, int j, boolean first) {
    g[i][j] = 0;
    res1[idx] = 'B';
    res2[idx] = i;
    res3[idx++] = j;
    for (int[] f : fs) {
      int nx = f[0] + i;
      int ny = f[1] + j;
      if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny] == 1) {
        dfs(nx, ny, false);
      }
    }
    if (!first) {
      res1[idx] = 'D';
      res2[idx] = i;
      res3[idx++] = j;
      res1[idx] = 'R';
      res2[idx] = i;
      res3[idx++] = j;
    }
  }


}
