package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DBerlandFair {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long t = in.nextLong();
    int[] a = in.nextInt(n);
    long res = 0;
    long cur = t;
    while (true) {
      long tmp = 0;
      long x = cur;
      int cnt = 0;

      for (int i = 0; i < n; i++) {
        if (a[i] <= x) {
          tmp += a[i];
          x -= a[i];
          cnt++;
        }
      }
      if (cnt == 0) {
        break;
      }
      res += cur / tmp * cnt;
      cur = x % tmp;
    }
    out.println(res);

  }
}
