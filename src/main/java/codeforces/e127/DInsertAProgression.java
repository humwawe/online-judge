package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DInsertAProgression {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    int[] a = new int[n + 1];
    int max = 0;
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      max = Math.max(a[i], max);
    }

    long sum = 0;
    for (int i = 1; i <= n - 1; i++) {
      sum += Math.abs(a[i] - a[i + 1]);
    }

    int res1 = Math.min(a[1] - 1, a[n] - 1);
    int res2 = Math.min(Math.abs(a[1] - x), Math.abs(a[n] - x));
    for (int i = 1; i < n; i++) {
      res1 = Math.min(res1, Math.abs(1 - a[i]) + Math.abs(1 - a[i + 1]) - Math.abs(a[i + 1] - a[i]));
      res2 = Math.min(res2, Math.abs(x - a[i]) + Math.abs(x - a[i + 1]) - Math.abs(a[i + 1] - a[i]));
    }
    if (x <= max) {
      out.println(sum + res1);
      return;
    }
    out.println(sum + res1 + res2);
  }
}
