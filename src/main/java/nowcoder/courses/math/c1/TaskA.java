package nowcoder.courses.math.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long x = in.nextLong();
    long y = in.nextLong();
    long m = in.nextLong();
    long n = in.nextLong();
    long l = in.nextLong();
    long aa = m - n;
    long bb = l;
    long cc = y - x;
    long g = gcd(aa, bb);
    if (cc % g != 0) {
      out.println("Impossible");
      return;
    }

    long[] exgcd = exgcd(aa, bb);

    exgcd[0] *= cc / exgcd[2];

    exgcd[0] = (exgcd[0] % (bb / g) + Math.abs(bb / g)) % Math.abs(bb / g);
    out.println(exgcd[0]);

  }

  public long gcd(long a, long b) {
    return b != 0 ? gcd(b, a % b) : a;
  }

  public long[] exgcd(long a, long b) {
    long[] xyg = new long[3];
    xyg[2] = exgcd0(a, b, xyg);
    return xyg;
  }

  private long exgcd0(long a, long b, long[] xy) {
    if (b == 0) {
      xy[0] = 1;
      xy[1] = 0;
      return a;
    }
    long g = exgcd0(b, a % b, xy);
    long tmp = xy[0];
    xy[0] = xy[1];
    xy[1] = tmp - a / b * xy[1];
    return g;
  }
}
