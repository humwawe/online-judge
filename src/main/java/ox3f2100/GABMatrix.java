package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class GABMatrix {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int[][] mat = new int[n][m];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      for (int k = 0; k < a; k++) {
        mat[i][idx++ % m] = 1;
      }
    }
    for (int i = 0; i < m; i++) {
      int t = 0;
      for (int j = 0; j < n; j++) {
        t += mat[j][i];
      }
      if (t != b) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        out.print(mat[i][j]);
      }
      out.println();
    }
  }
}
