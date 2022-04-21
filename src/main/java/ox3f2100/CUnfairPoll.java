package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CUnfairPoll {
  long n, m, k, x, y;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextLong();
    m = in.nextLong();
    k = in.nextLong();
    x = in.nextLong();
    y = in.nextLong();
    out.println(Math.max(f(n - 1, 1), Math.max(f(1, 1), f(2, 1))), f(n, m), f(x, y));
  }

  private long f(long a, long b) {
    if (n == 1) {
      return k / m + (k % m >= b ? 1 : 0);
    }
    long t = n * m + (n - 2) * m;
    long r = k % t;
    long p = (a - 1) * m + b;
    if (a == 1 || a == n) {
      return k / t + (r >= p ? 1 : 0);
    } else {
      return (2 * (k / t) + (r >= p ? 1 : 0) + (r >= (n * m + (n - 1 - a) * m + b) ? 1 : 0));
    }
  }
}
