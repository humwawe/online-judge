package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CCircleOfMonsters {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] a = new long[n];
    long[] b = new long[n];
    long[] c = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
      b[i] = in.nextLong();
    }

    c[0] = Math.max(0, a[0] - b[n - 1]);
    long sum = c[0];
    for (int i = 1; i < n; i++) {
      c[i] = Math.max(0, a[i] - b[i - 1]);
      sum += c[i];
    }
    long res = (long) 1e18;
    for (int i = 0; i < n; i++) {
      res = Math.min(res, sum - c[i] + a[i]);
    }
    out.println(res);
  }
}
