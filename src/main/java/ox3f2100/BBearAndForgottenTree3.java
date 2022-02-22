package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BBearAndForgottenTree3 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int d = in.nextInt();
    int h = in.nextInt();
    if (d > 2 * h) {
      out.println(-1);
      return;
    }
    if (d == 1 && n != 2) {
      out.println(-1);
      return;
    }
    for (int i = 1; i <= h; i++) {
      out.println(i, i + 1);
    }
    if (d == h) {
      for (int i = h + 2; i <= n; i++) {
        out.println(2, i);
      }
      return;
    }
    out.println(1, h + 2);
    for (int i = 1; i <= d - h - 1; i++) {
      out.println(h + 1 + i, h + 1 + i + 1);
    }
    for (int i = d + 2; i <= n; i++) {
      out.println(1, i);
    }
  }
}
