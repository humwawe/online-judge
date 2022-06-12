package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DOddEvenSubsequence {
  int n, k;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int l = 1;
    int r = (int) 1e9;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(mid)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    out.println(l);
  }

  private boolean check(int mid) {
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (cnt % 2 == 0) {
        if (a[i] <= mid) {
          cnt++;
        }
      } else {
        cnt++;
      }
    }
    if (cnt >= k) {
      return true;
    }
    cnt = 0;
    for (int i = 0; i < n; i++) {
      if (cnt % 2 == 1) {
        if (a[i] <= mid) {
          cnt++;
        }
      } else {
        cnt++;
      }
    }
    return cnt >= k;
  }
}
