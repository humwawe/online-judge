package codeforces.c775;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int res = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int i = 0;
    for (; i < n; i++) {
      if (a[i] != 1) {
        break;
      }
    }
    int j = n - 1;
    for (; j >= 0; j--) {
      if (a[j] != 1) {
        break;
      }
    }
    out.println(Math.max(0, j - i + 2));
  }
}
