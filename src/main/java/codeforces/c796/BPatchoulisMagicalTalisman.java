package codeforces.c796;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BPatchoulisMagicalTalisman {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int cnt1 = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] % 2 == 1) {
        cnt1++;
      }
    }

    if (cnt1 > 0) {
      out.println(n - cnt1);
      return;
    }
    int min = (int) 1e8;
    for (int i = 0; i < n; i++) {
      int tmp = 0;
      while (a[i] % 2 == 0) {
        a[i] /= 2;
        tmp++;
      }
      min = Math.min(min, tmp);
    }
    out.println(min + n - 1);
  }
}
