package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CProblemForNazar {
  int mod = (int) (1e9 + 7);

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long l = in.nextLong();
    long r = in.nextLong();
    out.println((helper(r) - helper(l - 1) + mod) % mod);
  }

  private long helper(long v) {
    long odd = 0;
    long even = 0;
    long next = 1;
    boolean f = true;
    while (v - next >= 0) {
      if (f) {
        odd += next;
      } else {
        even += next;
      }
      v -= next;
      next *= 2;
      f = !f;
    }

    if (v > 0) {
      if (f) {
        odd += v;
      } else {
        even += v;
      }
    }

    long o = odd % mod + odd % mod * ((odd - 1) % mod) % mod;
    long e = even % mod * 2 + even % mod * ((even - 1) % mod) % mod;
    return (o + e) % mod;
  }
}
