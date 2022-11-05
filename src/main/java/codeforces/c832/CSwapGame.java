package codeforces.c832;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CSwapGame {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int min = a[0];
    for (int i = 1; i < n; i++) {
      min = Math.min(min, a[i]);
    }
    if (min == a[0]) {
      out.println("Bob");
    } else {
      out.println("Alice");
    }

  }
}
