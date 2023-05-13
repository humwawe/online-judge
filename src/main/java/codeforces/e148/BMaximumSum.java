package codeforces.e148;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BMaximumSum {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    Arrays.sort(a);
    long[] sum = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      sum[i] = sum[i - 1] + a[i - 1];
    }
    long res = 0;
    for (int i = 0; i <= 2 * k; i += 2) {
      int l = i;
      int r = n - (k - (i / 2));
      res = Math.max(res, sum[r] - sum[l]);
    }
    out.println(res);
  }
}
