package codeforces.e130;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BPromo {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    Integer[] a = new Integer[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a, (x, y) -> y - x);
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + a[i];
    }
    for (int i = 0; i < q; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      out.println(sum[x] - sum[x - y]);
    }
  }
}
