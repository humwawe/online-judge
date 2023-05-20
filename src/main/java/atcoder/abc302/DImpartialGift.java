package atcoder.abc302;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.TreeSet;

public class DImpartialGift {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long d = in.nextLong();
    long[] a = in.nextLong(n);
    TreeSet<Long> b = new TreeSet<>();
    for (int i = 0; i < m; i++) {
      b.add(in.nextLong());
    }
    long res = -1;
    for (int i = 0; i < n; i++) {
      long x = a[i];
      Long floor = b.floor(x + d);
      if (floor != null && Math.abs(floor - x) <= d) {
        res = Math.max(res, x + floor);
      }
    }
    out.println(res);

  }
}
