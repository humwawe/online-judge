package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DMultiplicationTable {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long m = in.nextInt();
    long k = in.nextLong();

    long l = 1;
    long r = n * m;
    while (l < r) {
      long mid = l + r >> 1;
      long sum = 0;
      for (int i = 1; i <= n; i++) {
        sum += Math.min(m, mid / i);
      }
      if (sum >= k) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    out.println(l);
  }
}
