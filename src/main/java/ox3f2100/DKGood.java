package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DKGood {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long a = 1;
    long t = n * 2;
    while (t % 2 == 0) {
      t /= 2;
      a *= 2;
    }
    if (t == 1) {
      out.println(-1);
      return;
    }
    long b = 2 * n / a;
    out.println(Math.min(a, b));
  }
}
