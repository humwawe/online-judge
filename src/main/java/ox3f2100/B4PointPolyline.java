package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class B4PointPolyline {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int b = Math.max(n, m);
    int a = Math.min(n, m);
    if (a == 0) {
      if (m >= n) {
        out.printf("0 1\n0 %d\n0 0\n0 %d\n", m, m - 1);
      } else {
        out.printf("1 0\n%d 0\n0 0\n%d 0\n", n, n - 1);
      }
    } else if (2 * Math.sqrt((a - 1) * (a - 1) + b * b) > b + Math.sqrt(a * a + b * b)) {
      if (m > n) {
        out.printf("1 0\n%d %d\n0 0\n%d %d\n", n, m, n - 1, m);
      } else {
        out.printf("0 1\n%d %d\n0 0\n%d %d\n", n, m, n, m - 1);
      }
    } else {
      if (m > n) {
        out.printf("0 0\n%d %d\n%d 0\n0 %d\n", n, m, n, m);
      } else {
        out.printf("0 0\n%d %d\n0 %d\n%d 0\n", n, m, m, n);
      }
    }
  }
}
