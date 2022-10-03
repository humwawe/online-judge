package codeforces.c824;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BTeaWithTangerines {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    long res = 0;
    int t = 2 * a[0] - 1;
    for (int i = 1; i < n; i++) {
      res += (a[i] + t - 1) / t - 1;
    }
    out.println(res);
  }
}
