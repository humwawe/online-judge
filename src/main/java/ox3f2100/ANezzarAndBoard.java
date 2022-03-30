package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ANezzarAndBoard {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long k = in.nextLong();
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
    }
    for (int i = 1; i < n; i++) {
      a[i] -= a[0];
    }
    k -= a[0];
    long g = a[1];
    for (int i = 2; i < n; i++) {
      g = gcd(g, a[i]);
    }
    if (k % g == 0) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }

  long gcd(long a, long b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
