package codeforces.c802;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CHelpingTheNature {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    long[] b = new long[n];
    for (int i = 0; i < n; i++) {
      b[i] = a[i + 1] - a[i];
    }
    long res = 0;
    for (int i = 1; i < n; i++) {
      if (b[i] < 0) {
        res += -b[i];
        b[0] += b[i];
      } else if (b[i] > 0) {
        res += b[i];
      }
    }

    res += Math.abs(b[0]);

    out.println(res);
  }
}
