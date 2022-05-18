package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CRussianRoulette {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long k = in.nextLong();
    long p = in.nextLong();
    if (n % 2 == 1 && k > 0) {
      n--;
      k--;
    }
    if (2 * k > n) {
      long t = 2 * k - n;
      n -= t;
      k -= t;
    }
    while (p-- > 0) {
      long a = in.nextLong();
      if ((a > n) || ((a % 2 == 0) && ((n - a) / 2 < k))) {
        out.print('X');
      } else {
        out.print('.');
      }
    }
  }
}
