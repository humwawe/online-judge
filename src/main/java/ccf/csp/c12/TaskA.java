package ccf.csp.c12;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    Arrays.sort(a);
    int res = (int) 1e8;
    for (int i = 0; i < n - 1; i++) {
      res = Math.min(res, a[i + 1] - a[i]);
    }
    out.println(res);
  }
}
