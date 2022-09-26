package codeforces.c823;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMeetingOnTheLine {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
    }

    int[] c = new int[n];
    int[] d = new int[n];
    int max1 = (int) -1e9;
    int max2 = (int) -1e9;
    for (int i = 0; i < n; i++) {
      c[i] = a[i] + b[i];
      max1 = Math.max(max1, c[i]);
      d[i] = b[i] - a[i];
      max2 = Math.max(max2, d[i]);
    }
    out.println((double) (max1 - max2) / 2);

  }
}
