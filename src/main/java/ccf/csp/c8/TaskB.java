package ccf.csp.c8;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  boolean[][] vis;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    vis = new boolean[20][5];
    f:
    for (int cnt : a) {
      for (int i = 0; i < 20; i++) {
        for (int j = 0; j < 5; j++) {
          if (check(i, j, cnt)) {
            for (int k = 0; k < cnt; k++) {
              vis[i][j + k] = true;
              out.print(i * 5 + j + 1 + k, "");
            }
            out.println();
            continue f;
          }
        }
      }
      int c = 0;
      for (int i = 0; i < 20; i++) {
        for (int j = 0; j < 5; j++) {
          if (!vis[i][j]) {
            vis[i][j] = true;
            c++;
            out.print(i * 5 + j + 1, "");
            if (c == cnt) {
              out.println();
              continue f;
            }
          }
        }
      }
    }
  }

  private boolean check(int i, int j, int cnt) {
    if (5 - j < cnt) {
      return false;
    }
    for (int k = 0; k < cnt; k++) {
      if (vis[i][j + k]) {
        return false;
      }
    }
    return true;
  }
}
