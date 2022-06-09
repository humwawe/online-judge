package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DExams {
  int[] a, b;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    b = new int[m + 1];
    for (int i = 1; i <= m; i++) {
      b[i] = in.nextInt();
    }

    int l = 1;
    int r = n + 1;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(mid)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    if (l == n + 1) {
      out.println(-1);
    } else {
      out.println(l);
    }

  }

  private boolean check(int mid) {
    int[] cnt = new int[m + 1];
    for (int i = 1; i <= mid; i++) {
      if (a[i] > 0) {
        cnt[a[i]]++;
      }
    }
    int tot = 0;
    for (int i = 1; i <= mid; i++) {
      if (a[i] != 0) {
        if (cnt[a[i]] > 1) {
          cnt[a[i]]--;
          tot++;
        } else {
          if (tot < b[a[i]]) {
            return false;
          }
          tot -= b[a[i]];
        }
      } else {
        tot++;
      }
    }
    for (int i = 1; i <= m; i++) {
      if (cnt[i] != 1) {
        return false;
      }
    }
    return true;

  }
}
