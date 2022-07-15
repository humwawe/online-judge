package codeforces.c807;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class AMarkThePhotographer {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    int[] a = new int[2 * n];
    for (int i = 0; i < 2 * n; i++) {
      a[i] = in.nextInt();
    }
    Arrays.sort(a);

    for (int i = 0; i < n; i++) {
      if (a[i + n] < a[i] + x) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
  }
}
