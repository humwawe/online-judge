package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DPhoenixAndScience {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextInt();
    long t = 1;
    long x = 1;
    List<Long> res = new ArrayList<>();
    while (t + 2 * x <= n) {
      res.add(x);
      x *= 2;
      t += x;
    }
    if (t < n) {
      if (n - t >= x) {
        res.add(n - t - x);
      } else {
        long a = (n - t + x) / 2;
        long b = n - t + x - a;
        res.remove(res.size() - 1);
        res.add(a - x / 2);
        res.add(b - a);
      }
    }
    out.println(res.size());
    for (Long r : res) {
      out.print(r + " ");
    }
    out.println();
  }
}
