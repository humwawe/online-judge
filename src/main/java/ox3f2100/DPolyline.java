package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DPolyline {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] a = new int[6];
    for (int i = 0; i < 6; i++) {
      a[i] = in.nextInt();
    }
    int res = 20;

    for (int i = 0; i < 6; i += 2) {
      res = Math.min(res, helper(a, i));
    }
    out.println(res);
  }

  private int helper(int[] a, int i) {
    int p1x = a[(i + 6) % 6];
    int p1y = a[(i + 1 + 6) % 6];
    int p2x = a[(i + 2 + 6) % 6];
    int p2y = a[(i + 3 + 6) % 6];
    int p3x = a[(i + 4 + 6) % 6];
    int p3y = a[(i + 5 + 6) % 6];

    if (p1x == p2x && p2x == p3x) {
      return 1;
    }
    if (p1y == p2y && p2y == p3y) {
      return 1;
    }

    if (p1x == p2x) {
      if (p3y <= Math.min(p1y, p2y) || p3y >= Math.max(p1y, p2y)) {
        return 2;
      }
    }

    if (p1y == p2y) {
      if (p3x <= Math.min(p1x, p2x) || p3x >= Math.max(p1x, p2x)) {
        return 2;
      }

    }
    return 3;
  }
}
