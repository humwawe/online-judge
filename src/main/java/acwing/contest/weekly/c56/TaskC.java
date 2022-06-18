package acwing.contest.weekly.c56;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long p = in.nextLong();
    long q = in.nextLong();
    long b = in.nextLong();

    long d = gcd(p, q);
    p /= d;
    q /= d;
    if (p == 0) {
      out.println("YES");
      return;
    }
    while (true) {
      long g = gcd(b, q);
      if (g == 1) {
        break;
      }
      b = g;
      q /= g;
    }
    if (q == 1) {
      out.println("YES");
    } else {
      out.println("NO");
    }

  }

  long gcd(long a, long b) {
    return b != 0 ? gcd(b, a % b) : a;
  }

}
