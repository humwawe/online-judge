package ccf.csp.c14;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        b[i] = (a[i] + a[i + 1]) / 2;
      } else if (i == n - 1) {
        b[i] = (a[i] + a[i - 1]) / 2;
      } else {
        b[i] = (a[i] + a[i - 1] + a[i + 1]) / 3;
      }
    }
    out.println(b);
  }
}
