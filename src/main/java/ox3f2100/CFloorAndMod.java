package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CFloorAndMod {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long x = in.nextInt();
    long y = in.nextInt();
    long t = (long) Math.sqrt(x + 1);

    if (t > y) {
      out.println(y * (y - 1) / 2);
      return;
    }
    long res = (t - 1) * (t) / 2;
    long r;
    for (long l = t + 2; l <= y + 1; l = r + 1) {
      if (l > x) {
        break;
      }
      r = Math.min(y + 1, x / (x / l));
      res += (r - l + 1) * (x / l);
    }
    out.println(res);
  }
}
