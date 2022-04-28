package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CConstructingTests {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    if (x == 0) {
      out.println(1, 1);
      return;
    }

    for (int i = 1; i * i < x; i++) {
      if (x % i == 0) {
        int a = x / i;
        int b = i;
        int n = (a + b) / 2;
        int m = (a + b) / (a - b);
        if ((long) n * n - ((long) n / m) * ((long) n / m) == x) {
          out.println(n, m);
          return;
        }
      }
    }
    out.println(-1);
  }
}
