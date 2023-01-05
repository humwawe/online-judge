package codeforces.c842;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BQuickSort {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    int cur = 1;
    int res = n;
    for (int i = 0; i < n; i++) {
      if (cur == a[i]) {
        cur++;
        res--;
      }
    }
    out.println((res + k - 1) / k);
  }
}
