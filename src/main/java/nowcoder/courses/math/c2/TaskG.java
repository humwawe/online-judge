package nowcoder.courses.math.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.MathMeth;

import java.util.ArrayList;
import java.util.List;

public class TaskG {
  List<Long> list = new ArrayList<>();
  int[] a;
  boolean f = false;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int p = in.nextInt();
    a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    long t = p;
    list.add(t);
    while (t != 1) {
      long phi = MathMeth.phi(t);
      list.add(phi);
      t = phi;
    }
    int m = in.nextInt();
    for (int q = 0; q < m; q++) {
      int l = in.nextInt();
      int r = in.nextInt();
      r = Math.min(r, l + list.size() - 1);
      long res = 1;
      for (int i = r; i >= l; i--) {
        f = false;
        res = modPow(a[i], res, list.get(i - l));
        if (f) {
          res += list.get(i - l);
        }
      }
      out.println(res % p);
    }
  }

  public long modPow(long m, long k, long p) {
    long res = 1 % p, t = m;
    while (k > 0) {
      if ((k & 1) == 1) {
        if (res * t >= p) {
          f = true;
        }
        res = res * t % p;
      }
      if (t * t >= p) {
        f = true;
      }
      t = t * t % p;
      k >>= 1;
    }
    return res % p;
  }

}
