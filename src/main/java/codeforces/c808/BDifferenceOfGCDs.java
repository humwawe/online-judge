package codeforces.c808;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BDifferenceOfGCDs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long l = in.nextInt();
    long r = in.nextInt();
    long[] a = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = (l + i - 1) / i * i;
      if (a[i] > r) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
    for (int i = 1; i <= n; i++) {
      out.print(a[i], "");
    }
    out.println();
  }
}
