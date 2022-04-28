package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BBearAndTwoPaths {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    if (k - n < 1 || n == 4) {
      out.println(-1);
      return;
    }
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();
    out.print(a, c);
    for (int i = 1; i <= n; i++) {
      if (i != a && i != b && i != c && i != d) {
        out.print("", i);
      }
    }
    out.println("", d, b);
    out.print(c, a);
    for (int i = 1; i <= n; i++) {
      if (i != a && i != b && i != c && i != d) {
        out.print("", i);
      }
    }
    out.println("", b, d);
  }
}
