package codeforces.c840;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CAnotherArrayProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] a = new long[n];
    long max = 0;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
      max = Math.max(max, a[i]);
    }
    int s = -1;
    int e = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] == max) {
        if (s == -1) {
          s = i;
        }
        e = i;
      }
    }
    if (n == 2) {
      out.println(Math.max(sum, 2 * Math.abs(a[1] - a[0])));
      return;
    }

    if (s == 0 || e == n - 1) {
      out.println(max * n);
      return;
    }

    for (int i = 2; i < n - 2; i++) {
      if (a[i] == max) {
        out.println(max * n);
        return;
      }
    }

    if (n == 3) {
      sum = Math.max(sum, a[2] + a[1] - a[0]);
      sum = Math.max(sum, a[0] + a[1] - a[2]);
      sum = Math.max(sum, 3 * (a[1] - a[0]));
      sum = Math.max(sum, 3 * (a[1] - a[2]));
      sum = Math.max(sum, 3 * a[0]);
      sum = Math.max(sum, 3 * a[2]);
      out.println(sum);
      return;
    }

    out.println(max * n);


  }
}
