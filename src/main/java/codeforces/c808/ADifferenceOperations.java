package codeforces.c808;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ADifferenceOperations {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    for (int i = 1; i < n; i++) {
      if (a[i] % a[0] != 0) {
        out.println("NO");
        return;
      }
    }
    out.println("YES");
  }
}
