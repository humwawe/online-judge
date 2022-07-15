package codeforces.c807;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMarkTheDustSweeper {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int i = 0;
    while (i < n && a[i] == 0) {
      i++;
    }
    long res = 0;
    for (int j = i; j < n - 1; j++) {
      res += Math.max(a[j], 1);
    }
    out.println(res);
  }
}
