package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTrailingLovesOrLoeufs {
  long n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextLong();
    long b = in.nextLong();
    long res = (long) 1e18;
    for (long i = 2; i * i <= b; i++) {
      long c = 0;
      if (b % i == 0) {
        while (b % i == 0) {
          c++;
          b /= i;
        }
        res = Math.min(res, helper(i, c));
      }
    }
    if (b > 1) {
      res = Math.min(res, helper(b, 1));
    }
    out.println(res);
  }

  private long helper(long a, long b) {
    long num = 0;
    long t = n;
    while (a <= t) {
      num += t / a;
      t /= a;
    }
    return num / b;
  }
}
