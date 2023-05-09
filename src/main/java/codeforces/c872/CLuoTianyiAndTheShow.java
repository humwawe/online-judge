package codeforces.c872;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CLuoTianyiAndTheShow {
  int[] sum;
  int[] absent;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int cnt1 = 0;
    int cnt2 = 0;
    int[] a = new int[m];
    sum = new int[m + 1];
    absent = new int[m + 1];
    for (int i = 0; i < n; i++) {
      int x = in.nextInt() - 1;
      if (x == -1 - 1) {
        cnt1++;
      } else if (x == -2 - 1) {
        cnt2++;
      } else {
        a[x] = 1;
      }
    }

    for (int i = 0; i < m; i++) {
      sum[i + 1] = sum[i] + a[i];
      absent[i + 1] = absent[i] + (1 - a[i]);
    }
    int l = sum[m];
    int r = m;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(a, cnt1, cnt2, mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    out.println(l);
  }

  private boolean check(int[] a, int cnt1, int cnt2, int mid) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == 1) {
        int left = sum[i] + Math.min(absent[i], cnt1);
        int right = (sum[a.length] - sum[i]) + Math.min(absent[a.length] - absent[i], cnt2);
        if (left + right >= mid) {
          return true;
        }
      }
    }

    if (cnt2 > 0 && a[0] == 0) {
      int t = 1;
      t += Math.min(absent[a.length] - absent[1], cnt2 - 1) + sum[a.length];
      if (t >= mid) {
        return true;
      }
    }
    if (cnt1 > 0 && a[a.length - 1] == 0) {
      int t = 1;
      t += Math.min(absent[a.length - 1], cnt1 - 1) + sum[a.length];
      if (t >= mid) {
        return true;
      }
    }
    return false;

  }
}
