package codeforces.c809;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D1ChoppingCarrotsEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    int max = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      max = Math.max(max, a[i]);
    }
    if (k > max) {
      out.println(0);
      return;
    }
    int res = max + 5;
    f:
    for (int i = max; i >= 1; i--) {
      int x = 0;
      int y = max + 5;
      for (int j = 0; j < n; j++) {
        int l = 1;
        int r = k + 1;
        while (l < r) {
          int mid = l + r >> 1;
          if (a[j] / mid <= i) {
            r = mid;
          } else {
            l = mid + 1;
          }
        }
        if (l > k) {
          continue f;
        }

        int tmp = a[j] / l;
        x = Math.max(x, tmp);
        y = Math.min(y, tmp);
      }
      res = Math.min(res, x - y);
    }
    out.println(res);
  }
}
