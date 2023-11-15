package ccf.csp.c10;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    int sum = 0;
    int res = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
      if (sum >= k) {
        res++;
        sum = 0;
      }
    }
    if (sum > 0) {
      res++;
    }
    out.println(res);
  }
}
