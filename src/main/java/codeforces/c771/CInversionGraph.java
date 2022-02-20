package codeforces.c771;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CInversionGraph {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    int l = 0;
    int res = 0;
    for (int i = 1; i <= n; i++) {
      l = Math.max(a[i], l);
      if (l == i) {
        res++;
      }
    }
    out.println(res);
  }
}
