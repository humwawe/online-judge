package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BTolikAndHisUncle {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    for (int i = 1; i <= n / 2; i++) {
      for (int j = 1; j <= m; j++) {
        out.println(i, j);
        out.println(n - i + 1, m - j + 1);
      }
    }
    if ((n & 1) == 1) {
      for (int i = 1; i <= m / 2; i++) {
        out.println(n / 2 + 1, i);
        out.println(n / 2 + 1, m - i + 1);
      }
      if (m % 2 == 1) {
        out.println(n / 2 + 1, m / 2 + 1);
      }
    }
  }
}
