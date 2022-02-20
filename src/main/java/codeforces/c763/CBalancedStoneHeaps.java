package codeforces.c763;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBalancedStoneHeaps {
  int n;
  int[] h;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int l = 1;
    int r = (int) 1e9;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    out.println(l);
  }

  private boolean check(int mid) {
    int[] a = h.clone();
    for (int i = n - 1; i >= 2; i--) {
      if (a[i] < mid) {
        return false;
      }
      int d = Math.min(h[i], a[i] - mid) / 3;
      a[i - 1] += d;
      a[i - 2] += 2 * d;
    }
    return a[0] >= mid && a[1] >= mid;
  }
}
