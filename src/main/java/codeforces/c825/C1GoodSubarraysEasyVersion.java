package codeforces.c825;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class C1GoodSubarraysEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    long res = 0;
    int j = -1;
    for (int i = 0; i < n; i++) {
      while (j + 1 < n && a[j + 1] >= j + 1 - i + 1) {
        j++;
      }
      long len = j - i + 1;
      res += len;
    }

    out.println(res);
  }
}
