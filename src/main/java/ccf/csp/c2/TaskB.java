package ccf.csp.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = 105;
    int n = in.nextInt();

    boolean[][] vis = new boolean[N][N];
    for (int i = 0; i < n; i++) {
      int x1 = in.nextInt();
      int y1 = in.nextInt();
      int x2 = in.nextInt() - 1;
      int y2 = in.nextInt() - 1;

      for (int j = x1; j <= x2; j++) {
        for (int k = y1; k <= y2; k++) {
          vis[j][k] = true;
        }
      }
    }
    int res = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (vis[i][j]) {
          res++;
        }
      }
    }
    out.println(res);
  }
}
