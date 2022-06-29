package codeforces.c803;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AXORMixup {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum ^= a[i];
    }
    for (int i = 0; i < n; i++) {
      if ((a[i] ^ sum) == a[i]) {
        out.println(a[i]);
        return;
      }
    }
  }
}
