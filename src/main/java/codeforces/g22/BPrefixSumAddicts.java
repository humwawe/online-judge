package codeforces.g22;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BPrefixSumAddicts {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    long[] s = new long[k];
    for (int i = 0; i < k; i++) {
      s[i] = in.nextInt();
    }
    if (k == 1) {
      out.println("Yes");
      return;
    }
    long[] a = new long[n];
    int j = k - 1;
    for (int i = n - 1; i >= 0 && j >= 1; i--, j--) {
      a[i] = s[j] - s[j - 1];
    }
    long t = 0;
    for (int i = 1; i < n - k + 1; i++) {
      a[i] = a[n - k + 1];
      t += a[i];
    }
    a[0] = s[0] - t;
    for (int i = 0; i < n - 1; i++) {
      if (a[i] > a[i + 1]) {
        out.println("No");
        return;
      }
    }
    out.println("Yes");
  }
}
