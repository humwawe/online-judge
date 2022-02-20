package codeforces.c730;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CNeedForPinkSlips {
  double c, m, p, v;
  double eps = 1e-9;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    c = in.nextDouble();
    m = in.nextDouble();
    p = in.nextDouble();
    v = in.nextDouble();
    out.println(dfs(c, m, p));

  }

  private double dfs(double c, double m, double p) {
    double res = p;
    if (c > 0) {
      double t = Math.min(c, v);
      double nc = c - t;
      double nm = m + t / 2;
      double np = p + t / 2;
      if (eps > m) {
        np = p + t;
        nm = m;
      }
      res += c * (1 + dfs(nc, nm, np));
    }
    if (m > 0) {
      double t = Math.min(m, v);
      double nm = m - t;
      double nc = c + t / 2;
      double np = p + t / 2;
      if (eps > c) {
        np = p + t;
        nc = c;
      }
      res += m * (1 + dfs(nc, nm, np));
    }
    return res;
  }
}
