package acwing.contest.weekly.c109;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  int[] a, b;
  double[] t;
  final double eps = 1e-6;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int v = in.nextInt();
    a = in.nextInt(n);
    b = in.nextInt(n);
    t = new double[n];
    double sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
    }
    for (int i = 0; i < n; i++) {
      t[i] = a[i] / sum;
    }
    double l = 0;
    double r = v;
    while (r - l > eps) {
      double mid = (l + r) / 2;
      if (check(mid)) {
        l = mid;
      } else {
        r = mid;
      }
    }
    out.println(l);
  }

  private boolean check(double mid) {
    for (int i = 0; i < t.length; i++) {
      if (mid * t[i] > b[i]) {
        return false;
      }
    }
    return true;
  }


}
