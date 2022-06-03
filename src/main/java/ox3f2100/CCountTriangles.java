package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CCountTriangles {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    int d = in.nextInt();
    long res = 0;
    for (int i = 1; i <= 1e6; i++) {

      int x = Math.max(i - c, a);
      int y = Math.min(i - b, b);
      int t1 = y - x + 1;

      int t2 = Math.min(i - 1, d) - c + 1;
      if (t1 <= 0 || t2 <= 0) {
        continue;
      }
      res += (long) t1 * t2;
    }
    out.println(res);
  }
}
