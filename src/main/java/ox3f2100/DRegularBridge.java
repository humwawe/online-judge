package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DRegularBridge {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int k = in.nextInt();
    if (k % 2 == 0) {
      out.println("NO");
      return;
    }
    out.println("YES");
    int n = 4 * k - 2;
    int m = n * k / 2;
    out.println(n, m);
    out.println(1, n / 2 + 1);

    for (int i = 2; i <= k; i++) {
      out.println(1, i);
      out.println(1 + n / 2, i + n / 2);
    }
    for (int i = 2; i <= k; i++) {
      for (int j = k + 1; j <= 2 * k - 1; j++) {
        out.println(i, j);
        out.println(i + n / 2, j + n / 2);
      }
    }
    for (int j = k + 1; j <= 2 * k - 1; j += 2) {
      out.println(j, j + 1);
      out.println(j + n / 2, j + 1 + n / 2);
    }
  }
}
