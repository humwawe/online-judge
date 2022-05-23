package codeforces.c793;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BANDSorting {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      b[i] = a[i];
    }
    Arrays.sort(b);
    int x = (1 << 30) - 1;
    for (int i = 0; i < n; i++) {
      if (a[i] != b[i]) {
        x &= a[i];
      }
    }
    out.println(x);
  }
}
