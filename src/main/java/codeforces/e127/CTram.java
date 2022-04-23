package codeforces.e127;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTram {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int s = in.nextInt();
    int x1 = in.nextInt();
    int x2 = in.nextInt();
    int t1 = in.nextInt();
    int t2 = in.nextInt();
    int p = in.nextInt();
    int d = in.nextInt();
    if (x1 > x2) {
      x1 = 2 * s - x1;
      x2 = 2 * s - x2;
    }
    int t = t2 * (x2 - x1);
    if (d == -1) {
      p = 2 * s - p;
    }
    if (p > x1) {
      p -= 2 * s;
    }
    if (t > (x2 - p) * t1) {
      t = (x2 - p) * t1;
    }
    out.println(t);
  }
}
