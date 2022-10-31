package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CCreativeSnap {
  int n, k, a, b;
  long[] c;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    a = in.nextInt();
    b = in.nextInt();
    c = new long[k];
    for (int i = 0; i < k; i++) {
      c[i] = in.nextInt();
    }
    Arrays.sort(c);
    out.println(helper(1, 1L << n));
  }

  private long helper(long l, long r) {
    long cnt = upperBound(c, r, 0, k) - lowerBound(c, l, 0, k);
    if (cnt == 0) {
      return a;
    }
    if (l == r) {
      return b * cnt;
    }
    long mid = l + r >> 1;
    return Math.min(helper(l, mid) + helper(mid + 1, r), b * cnt * (r - l + 1));
  }

  long lowerBound(long[] a, long t, int l, int r) {
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

  // [l,r) 从左往右找第一个大于t的数，返回插入位置
  int upperBound(long[] a, long t, int l, int r) {
    while (l < r) {
      int mid = l + r >> 1;
      if (a[mid] <= t) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    return l;
  }
}
