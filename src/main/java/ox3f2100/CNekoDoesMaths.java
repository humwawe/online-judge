package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CNekoDoesMaths {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextLong();
    long b = in.nextLong();
    if (b > a) {
      long t = a;
      a = b;
      b = t;
    }
    if (a % b == 0) {
      out.println(0);
      return;
    }
    long x = a - b;
    long res = (long) 1e15;
    long ans = (long) 1e15;
    for (int i = 1; i * i <= x; i++) {
      if (x % i == 0) {
        long m1 = i;
        long k = (b + m1 - 1) / m1 * m1 - b;
        long tmp = (a + k) * (b + k) / m1;
        if (tmp < res) {
          ans = k;
          res = tmp;
        } else if (tmp == res) {
          ans = Math.min(ans, k);
        }
        m1 = x / i;
        k = (b + m1 - 1) / m1 * m1 - b;
        tmp = (a + k) * (b + k) / m1;
        if (tmp < res) {
          ans = k;
          res = tmp;
        } else if (tmp == res) {
          ans = Math.min(ans, k);
        }
      }

    }
    out.println(ans);
  }
}
