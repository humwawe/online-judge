package ccf.csp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  char[][] a;
  int n, m;
  boolean[][] vis;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    m = in.nextInt();
    n = in.nextInt();
    a = new char[n][m];
    vis = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(a[i], '.');
    }
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int type = in.nextInt();
      if (type == 0) {
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int[] s = new int[]{n - 1 - y1, x1};
        int[] t = new int[]{n - 1 - y2, x2};
        draw(s, t);
      } else {

        int x = in.nextInt();
        int y = in.nextInt();
        char c = in.nextCharacter();
        int[] s = new int[]{n - 1 - y, x};
        for (int j = 0; j < n; j++) {
          Arrays.fill(vis[j], false);
        }
        draw(s, c);
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        out.print(a[i][j]);
      }
      out.println();
    }
  }

  private void draw(int[] s, char c) {
    int x = s[0];
    int y = s[1];
    a[x][y] = c;
    vis[x][y] = true;
    int[][] fs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int[] f : fs) {
      int nx = x + f[0];
      int ny = y + f[1];
      if (nx >= 0 && nx < n && ny >= 0 && ny < m && a[nx][ny] != '-' && a[nx][ny] != '+' && a[nx][ny] != '|' && !vis[nx][ny]) {
        draw(new int[]{nx, ny}, c);
      }
    }

  }

  private void draw(int[] s, int[] t) {
    if (s[0] == t[0]) {
      for (int i = Math.min(s[1], t[1]); i <= Math.max(s[1], t[1]); i++) {
        if (a[s[0]][i] == '+') {
          continue;
        }
        if (a[s[0]][i] == '|') {
          a[s[0]][i] = '+';
        } else {
          a[s[0]][i] = '-';
        }
      }
    }

    if (s[1] == t[1]) {
      for (int i = Math.min(s[0], t[0]); i <= Math.max(s[0], t[0]); i++) {
        if (a[i][s[1]] == '+') {
          continue;
        }
        if (a[i][s[1]] == '-') {
          a[i][s[1]] = '+';
        } else {
          a[i][s[1]] = '|';
        }
      }
    }
  }
}
