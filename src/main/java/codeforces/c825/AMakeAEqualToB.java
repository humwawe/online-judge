package codeforces.c825;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class AMakeAEqualToB {
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
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] != b[i]) {
        res++;
      }
    }

    Arrays.sort(a);
    Arrays.sort(b);
    int t = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] != b[i]) {
        t++;
      }
    }
    out.println(Math.min(res, t + 1));

  }
}
