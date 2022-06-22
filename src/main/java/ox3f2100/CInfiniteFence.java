package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CInfiniteFence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long r = in.nextInt();
    long b = in.nextInt();
    long k = in.nextInt();

    if (r == b) {
      out.println("OBEY");
      return;
    }

    if (r > b) {
      long t = r;
      r = b;
      b = t;
    }


    long g = gcd(r, b);

    r /= g;
    b /= g;

    if ((k - 1) * r + 1 < b) {
      out.println("REBEL");
    } else {
      out.println("OBEY");
    }

  }


  private long gcd(long a, long b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
