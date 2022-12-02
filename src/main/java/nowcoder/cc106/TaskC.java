package nowcoder.cc106;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n][n];
    for (int i = 1; i < n; i += 2) {
      for (int j = 0; j < n; j++) {
        a[i][j] = 1;
      }
    }

    for (int i = 1; i < n - 1; i += 2) {
      a[i][0] = 0;
    }

    for (int i = 2; i < n - 1; i += 2) {
      a[i][n - 1] = 1;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(a[i][j]);
      }
      out.println();
    }
  }
}
