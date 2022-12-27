package codeforces.c841;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AJoeyTakesMoney {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] a = new long[n];
    long x = 1;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
      x *= a[i];
    }

    out.println(2022 * (x + n - 1));
  }
}
