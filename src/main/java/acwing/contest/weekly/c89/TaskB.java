package acwing.contest.weekly.c89;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    int[][] b = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
        b[i][j] = 1;
      }
    }

    boolean[] vis1 = new boolean[n];
    boolean[] vis2 = new boolean[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 0) {
          vis1[i] = true;
          vis2[j] = true;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (vis1[i]) {
        for (int j = 0; j < m; j++) {
          b[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      if (vis2[i]) {
        for (int j = 0; j < n; j++) {
          b[j][i] = 0;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 1) {
          boolean f = false;
          for (int k = 0; k < m; k++) {
            if (b[i][k] == 1) {
              f = true;
            }
          }
          for (int k = 0; k < n; k++) {
            if (b[k][j] == 1) {
              f = true;
            }
          }
          if (!f) {
            out.println("NO");
            return;
          }
        }
      }
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        out.print(b[i][j], "");
      }
      out.println();
    }

  }
}
