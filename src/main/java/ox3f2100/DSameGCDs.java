package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DSameGCDs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextLong();
    long b = in.nextLong();

    long g = gcd(a, b);
    out.println(phi(b / g));

  }

  long phi(long x) {
    long res = x;
    for (int i = 2; i <= x / i; i++) {
      if (x % i == 0) {
        res = res / i * (i - 1);
        while (x % i == 0) {
          x /= i;
        }
      }
    }
    if (x > 1) {
      res = res / x * (x - 1);
    }

    return res;
  }

  long gcd(long a, long b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
