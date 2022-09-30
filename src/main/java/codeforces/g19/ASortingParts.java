package codeforces.g19;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ASortingParts {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    for (int i = 0; i < n - 1; i++) {
      if (a[i] > a[i + 1]) {
        out.println("YES");
        return;
      }
    }
    out.println("NO");
  }
}
