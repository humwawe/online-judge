package codeforces.c772;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BAvoidLocalMaximums {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int cnt = 0;
    for (int i = 1; i < n - 1; i++) {
      if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
        a[i + 1] = Math.max(a[i], a[i + 2]);
        cnt++;
      }
    }
    out.println(cnt);
    for (int i = 0; i < n; i++) {
      out.print(a[i], "");
    }
    out.println();
  }
}
