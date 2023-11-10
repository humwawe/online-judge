package ccf.csp.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
      }
    }
    boolean[][] vis = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j - 2 >= 0 && a[i][j] == a[i][j - 1] && a[i][j] == a[i][j - 2]) {
          vis[i][j] = true;
        }
        if (j + 2 < m && a[i][j] == a[i][j + 1] && a[i][j] == a[i][j + 2]) {
          vis[i][j] = true;
        }
        if (i - 2 >= 0 && a[i][j] == a[i - 1][j] && a[i - 2][j] == a[i][j]) {
          vis[i][j] = true;
        }
        if (i + 2 < n && a[i][j] == a[i + 1][j] && a[i + 2][j] == a[i][j]) {
          vis[i][j] = true;
        }
        if (j - 1 >= 0 && j + 1 < m && a[i][j] == a[i][j - 1] && a[i][j] == a[i][j + 1]) {
          vis[i][j] = true;
        }

        if (i - 1 >= 0 && i + 1 < n && a[i][j] == a[i - 1][j] && a[i][j] == a[i + 1][j]) {
          vis[i][j] = true;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (vis[i][j]) {
          out.print(0, "");
        } else {
          out.print(a[i][j], "");
        }
      }
      out.println();
    }
  }
}
