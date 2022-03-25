package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class BAromasSearch {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long x0 = in.nextLong();
    long y0 = in.nextLong();
    long ax = in.nextLong();
    long ay = in.nextLong();
    long bx = in.nextLong();
    long by = in.nextLong();
    long xs = in.nextLong();
    long ys = in.nextLong();
    long t = in.nextLong();
    long lim = Long.MAX_VALUE / 2;
    List<Long> x = new ArrayList<>();
    List<Long> y = new ArrayList<>();
    x.add(x0);
    y.add(y0);
    int n = 1;
    while ((lim - bx) / ax >= x.get(n - 1) && (lim - by) / ay >= y.get(n - 1)) {
      x.add(ax * x.get(n - 1) + bx);
      y.add(ay * y.get(n - 1) + by);
      n++;
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        long len = x.get(j) - x.get(i) + y.get(j) - y.get(i);
        long left = Math.abs(xs - x.get(i)) + Math.abs(ys - y.get(i));
        long right = Math.abs(xs - x.get(j)) + Math.abs(ys - y.get(j));
        if (t - left >= len || t - right >= len) {
          res = Math.max(res, j - i + 1);
        }
      }
    }
    out.println(res);

  }
}
