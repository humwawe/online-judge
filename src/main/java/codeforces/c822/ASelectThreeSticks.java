package codeforces.c822;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class ASelectThreeSticks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    long res = (long) 1e12;
    for (int i = 1; i < n - 1; i++) {
      res = Math.min(res, a[i + 1] - a[i] + a[i] - a[i - 1]);
    }
    out.println(res);
  }
}
