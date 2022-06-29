package codeforces.c803;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BRisingSand {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    if (k == 1) {
      out.println((n - 1) / 2);
      return;
    }
    int res = 0;
    for (int i = 1; i < n - 1; i++) {
      if (a[i] > a[i - 1] + a[i + 1]) {
        res++;
      }
    }
    out.println(res);
  }
}
