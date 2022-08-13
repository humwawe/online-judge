package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.math.BigInteger;

public class CTheFootballSeason {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long p = in.nextLong();
    long w = in.nextLong();
    long d = in.nextLong();
    long g = exgcd(w, d);

    if (p % g != 0) {
      out.println(-1);
      return;
    }

    long w0 = w / g;
    long d0 = d / g;

    BigInteger xx = BigInteger.valueOf(x).multiply(BigInteger.valueOf(p / g));
    BigInteger yy = BigInteger.valueOf(y).multiply(BigInteger.valueOf(p / g));

    BigInteger minY = yy.mod(BigInteger.valueOf(w0));

    BigInteger minX = xx.subtract(minY.subtract(yy).divide(BigInteger.valueOf(w0)).multiply(BigInteger.valueOf(d0)));
    x = Long.parseLong(minX.toString());
    y = Long.parseLong(minY.toString());
    if (x < 0 || y < 0) {
      out.println(-1);
      return;
    }
    long z = n - x - y;
    if (z < 0) {
      out.println(-1);
      return;
    }
    out.println(x, y, z);
  }


  long x, y;

  long exgcd(long a, long b) {
    if (b == 0) {
      x = 1;
      y = 0;
      return a;
    }
    long d = exgcd(b, a % b);
    long tmp = x;
    x = y;
    y = tmp - a / b * y;
    return d;
  }
}
