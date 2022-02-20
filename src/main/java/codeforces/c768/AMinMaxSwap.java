package codeforces.c768;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AMinMaxSwap {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      max = Math.max(max, a[i]);
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
      max = Math.max(max, b[i]);
    }
    int max2 = 0;
    for (int i = 0; i < n; i++) {
      max2 = Math.max(max2, Math.min(a[i], b[i]));
    }
    out.println(max * max2);
  }
}
