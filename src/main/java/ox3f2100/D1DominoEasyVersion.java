package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D1DominoEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    if (n % 2 == 0 && m % 2 == 0) {
      if (k % 2 == 0) {
        out.println("YES");
      } else {
        out.println("NO");
      }
    } else if (n % 2 == 0 && m % 2 == 1) {
      if (k <= m / 2 * n && k % 2 == 0) {
        out.println("YES");
      } else {
        out.println("NO");
      }
    } else {
      if (k >= m / 2 && (k - m / 2) % 2 == 0) {
        out.println("YES");
      } else {
        out.println("NO");
      }
    }

  }
}
