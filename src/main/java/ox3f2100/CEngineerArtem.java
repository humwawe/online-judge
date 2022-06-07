package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CEngineerArtem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if ((i + j) % 2 == 0) {
          if (a[i][j] % 2 == 0) {
            a[i][j] += 1;
          }
        } else {
          if (a[i][j] % 2 == 1) {
            a[i][j] += 1;
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      out.println(a[i]);
    }
  }
}
