package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class E3Cycles {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = n / 2;
    int b = n - a;
    out.println(a * b);
    for (int i = 1; i <= a; i++) {
      for (int j = a + 1; j <= n; j++) {
        out.println(i, j);
      }
    }
  }
}
