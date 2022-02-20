package codeforces.e114;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CSlayTheDragon {
  long sum;
  long[] a;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
    }
    sum = 0;
    sort(a);
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      long x = in.nextLong();
      long y = in.nextLong();
      int idx = lowerBound(x);
      if (idx == n) {
        out.println(x - a[n - 1] + Math.max(0, y - (sum - a[n - 1])));
      } else if (a[idx] == x) {
        out.println(Math.max(0, y - (sum - a[idx])));
      } else {
        long tmp = Math.max(0, y - (sum - a[idx]));
        if (idx > 0) {
          tmp = Math.min(tmp, x - a[idx - 1] + Math.max(0, y - (sum - a[idx - 1])));
        }
        out.println(tmp);
      }
    }
  }

  int lowerBound(long t) {
    int l = 0;
    int r = n;
    while (l < r) {
      int mid = l + r >> 1;
      if (a[mid] >= t) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  private void sort(long[] a) {
    Long[] tmp = new Long[a.length];
    for (int i = 0; i < tmp.length; i++) {
      tmp[i] = a[i];
    }
    Arrays.sort(tmp);
    for (int i = 0; i < a.length; i++) {
      a[i] = tmp[i];
      sum += a[i];
    }
  }
}
