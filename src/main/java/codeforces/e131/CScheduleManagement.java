package codeforces.e131;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CScheduleManagement {
  int n, m;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    a = new int[m];
    for (int i = 0; i < m; i++) {
      a[i] = in.nextInt() - 1;
    }
    int l = 1;
    int r = 2 * m;
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

  private boolean check(long mid) {
    long[] cnt = new long[n];
    Arrays.fill(cnt, mid);

    long c = 0;

    for (int i = 0; i < m; i++) {
      if (cnt[a[i]] > 0) {
        cnt[a[i]]--;
      } else {
        c++;
      }
    }
    for (int i = 0; i < n; i++) {
      c -= cnt[i] / 2;
    }
    return c <= 0;

  }
}
