package ccf.csp.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int res = 0;
    for (int i = 1; i < n; i++) {
      if (a[i] != a[i - 1]) {
        res++;
      }
    }
    out.println(res + 1);
  }
}
