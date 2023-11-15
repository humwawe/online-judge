package ccf.csp.c10;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = i;
    }
    int m = in.nextInt();

    for (int i = 0; i < m; i++) {
      int p = in.nextInt() - 1;
      int q = in.nextInt();
      int j = 0;
      for (j = 0; j < n; j++) {
        if (a[j] == p) {
          break;
        }
      }

      if (q > 0) {
        for (int k = j + 1; k <= q + j; k++) {
          a[k - 1] = a[k];
        }
        a[q + j] = p;

      } else if (q < 0) {
        for (int k = j - 1; k >= q + j; k--) {
          a[k + 1] = a[k];
        }
        a[q + j] = p;
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(a[i] + 1, "");
    }
    out.println();
  }
}
