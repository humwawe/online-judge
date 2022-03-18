package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APlusAndSquareRoot {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      if (i == 1) {
        out.println(2);
      } else {
        out.println((long) i * (i + 1) * (i + 1) - (i - 1));
      }
    }
  }
}
