package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BConsecutivePointsSegment {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int seg = a[n - 1] - a[0];
    if (seg < n + 2) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}
