package codeforces.c746;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class AGamerHemose {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long h = in.nextInt();
    Integer[] a = new Integer[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);
    long m1 = a[n - 1];
    long m2 = a[n - 2];
    long cnt = (h + m1 + m2 - 1) / (m1 + m2);
    if (cnt * (m1 + m2) - m2 >= h) {
      out.println(cnt * 2 - 1);
    } else {
      out.println(cnt * 2);
    }
  }
}
