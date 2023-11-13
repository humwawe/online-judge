package ccf.csp.c8;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int res = 0;
    for (int i = 1; i < n; i++) {
      res = Math.max(res, Math.abs(a[i] - a[i - 1]));
    }
    out.println(res);
  }
}
