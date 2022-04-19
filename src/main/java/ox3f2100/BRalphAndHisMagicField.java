package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BRalphAndHisMagicField {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long m = in.nextLong();
    int k = in.nextInt();
    if (Math.abs(n - m) % 2 == 1 && k == -1) {
      out.println(0);
    } else {
      int mod = (int) (1e9 + 7);
      out.println(qp(qp(2, m - 1, mod), n - 1, mod));
    }
  }

  int qp(int m, long k, int p) {
    long res = 1 % p, t = m;
    while (k > 0) {
      if ((k & 1) == 1) {
        res = res * t % p;
      }
      t = t * t % p;
      k >>= 1;
    }
    return (int) res % p;
  }
}
