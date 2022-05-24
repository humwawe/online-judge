package codeforces.e129;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BCardTrick {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int start = 0;
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      start += x;
      start %= n;
    }
    out.println(a[start]);
  }
}
