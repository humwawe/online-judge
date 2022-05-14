package codeforces.e128;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AMinimumsAndMaximums {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int l1 = in.nextInt();
    int r1 = in.nextInt();
    int l2 = in.nextInt();
    int r2 = in.nextInt();
    int t = Math.max(l1, l2);
    if (l1 <= t && t <= r1 && l2 <= t && t <= r2) {
      out.println(t);
      return;
    }
    out.println(l1 + l2);
  }
}
