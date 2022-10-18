package codeforces.e137;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APassword {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int x = 10 - n;
    out.println(x * (x - 1) * 3);
  }
}
