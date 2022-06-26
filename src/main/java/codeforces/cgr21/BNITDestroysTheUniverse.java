package codeforces.cgr21;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BNITDestroysTheUniverse {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    int res = 0;
    for (int i = 1; i <= n; i++) {
      if (a[i] != 0 && a[i - 1] == 0) {
        res++;
      }
    }
    out.println(Math.min(res, 2));
  }
}
