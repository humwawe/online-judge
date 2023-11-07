package ccf.csp.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt(m);
    }

    int[][] res = new int[m][n];

    int idx = 0;
    for (int j = m - 1; j >= 0; j--) {
      for (int i = 0; i < n; i++) {
        res[idx][i] = a[i][j];
      }
      idx++;
    }
    for (int i = 0; i < m; i++) {
      out.println(res[i]);
    }
  }
}
