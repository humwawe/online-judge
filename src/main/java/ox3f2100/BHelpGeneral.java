package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BHelpGeneral {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    if (n == 1 || m == 1) {
      out.println(Math.max(n, m));
      return;
    }
    if (Math.min(n, m) == 2) {
      int max = Math.max(n, m);
      if (max % 4 <= 2) {
        out.println(max + max % 4);
      } else {
        out.println(max + 1);
      }
      return;
    }
    out.println((n * m + 1) / 2);
  }
}
