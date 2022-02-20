package codeforces.c738;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMochaAndHiking {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    boolean f = false;
    int idx0 = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] == 0) {
        f = true;
        idx0 = i + 1;
      }
    }
    if (!f) {
      out.print(n + 1 + " ");
      for (int i = 1; i <= n; i++) {
        out.print(i + " ");
      }
      out.println();
      return;
    }

    for (int i = 1; i <= idx0; i++) {
      out.print(i + " ");
    }
    out.print(n + 1 + " ");
    for (int i = idx0 + 1; i <= n; i++) {
      out.println(i);
    }
    out.println();
  }
}
