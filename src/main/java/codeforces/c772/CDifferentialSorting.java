package codeforces.c772;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CDifferentialSorting {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    if (a[n - 2] > a[n - 1]) {
      out.println(-1);
      return;
    }
    boolean f = false;
    for (int i = 0; i < n - 1; i++) {
      if (a[i] > a[i + 1]) {
        f = true;
        break;
      }
    }
    if (!f) {
      out.println(0);
      return;
    }

    if (a[n - 2] - a[n - 1] <= a[n - 2]) {
      out.println(n - 2);
      for (int i = 1; i <= n - 2; i++) {
        out.println(i, n - 1, n);
      }
    } else {
      out.println(-1);
    }

  }
}
