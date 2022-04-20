package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMaximalGCD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long k = in.nextLong();

    if (k + 1 > n * 2 / k) {
      out.println(-1);
      return;
    }

    long min = k * (k + 1) / 2;

    long res = 0;

    for (long i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        long x = i;
        long y = n / i;

        if (min <= y) {
          res = Math.max(x, res);
        }
        if (min <= x) {
          res = Math.max(y, res);
        }
      }
    }

    if (res == 0) {
      out.println(-1);
      return;
    }

    for (int i = 1; i < k; i++) {
      out.print(i * res + " ");
    }
    long last = n - ((k - 1) * k / 2) * res;
    out.println(last);

  }
}
