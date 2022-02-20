package codeforces.c729;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CStrangeFunction {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long res = 0;
    long t = 1;
    int mod = (int) (1e9 + 7);
    for (int i = 1; t <= n; i++) {
      res = (res + n / t) % mod;
      t = lcm(t, i);
    }
    out.println(res);
  }

  long lcm(long a, long b) {
    return a * b / gcd(a, b);
  }

  long gcd(long a, long b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
