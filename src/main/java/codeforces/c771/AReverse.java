package codeforces.c771;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AReverse {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    int s = 1;
    while (s <= n && a[s] == s) {
      s++;
    }
    int e = 0;
    for (int i = 1; i <= n; i++) {
      if (a[i] == s) {
        e = i;
      }
    }
    while (s < e) {
      int t = a[s];
      a[s] = a[e];
      a[e] = t;
      s++;
      e--;
    }
    for (int i = 1; i <= n; i++) {
      out.print(a[i] + " ");
    }
    out.println();
  }
}
