package codeforces.e124;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CFaultTolerantNetwork {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }
    long res = Math.min(Math.abs(a[0] - b[0]) + Math.abs(a[n - 1] - b[n - 1]), Math.abs(a[0] - b[n - 1]) + Math.abs(b[0] - a[n - 1]));

    long x1 = Long.MAX_VALUE;
    long x2 = Long.MAX_VALUE;
    long y1 = Long.MAX_VALUE;
    long y2 = Long.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      x1 = Math.min(x1, Math.abs(a[0] - b[i]));
      x2 = Math.min(x2, Math.abs(b[0] - a[i]));
      y1 = Math.min(y1, Math.abs(a[n - 1] - b[i]));
      y2 = Math.min(y2, Math.abs(b[n - 1] - a[i]));
    }
    res = Math.min(res, x1 + x2 + y1 + y2);
    res = Math.min(res, x2 + y1 + Math.abs(a[0] - b[n - 1]));
    res = Math.min(res, x1 + y2 + Math.abs(b[0] - a[n - 1]));
    res = Math.min(res, x1 + x2 + Math.abs(a[n - 1] - b[n - 1]));
    res = Math.min(res, y1 + y2 + Math.abs(a[0] - b[0]));
    out.println(res);
  }
}
