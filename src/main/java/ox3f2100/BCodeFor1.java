package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BCodeFor1 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long l = in.nextLong();
    long r = in.nextLong();
    int res = 0;
    for (long i = l; i <= r; i++) {
      res += helper(n, i);
    }
    out.println(res);

  }

  private int helper(long n, long pos) {
    long t = n;
    long mid = 1;
    while ((t >> 1) > 0) {
      mid <<= 1;
      t >>= 1;
    }
    if (pos < mid) {
      return helper(n >> 1, pos);
    } else if (pos > mid) {
      return helper(n >> 1, pos - mid);
    }
    return (int) (n % 2);
  }
}
