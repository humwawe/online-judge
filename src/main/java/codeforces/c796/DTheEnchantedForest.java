package codeforces.c796;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTheEnchantedForest {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + a[i];
    }
    int t = k;
    if (k >= n) {
      t = n;
    }
    long max = 0;
    for (int i = 0; i + t <= n; i++) {
      max = Math.max(max, sum[i + t] - sum[i]);
    }
    if (k >= n) {
      long res = (long) k * n - (long) n * (n + 1) / 2;
      out.println(res + max);
    } else {
      long res = (long) k * (k - 1) / 2;
      out.println(res + max);
    }

  }
}
