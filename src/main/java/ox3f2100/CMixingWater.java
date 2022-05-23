package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMixingWater {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int h = in.nextInt();
    int c = in.nextInt();
    long t = in.nextInt();
    if (h + c - 2 * t >= 0) {
      out.println(2);
    } else {
      long a = h - t;
      long b = 2 * t - c - h;
      long k = 2 * (a / b) + 1;
      long val1 = Math.abs(k / 2 * c + (k + 1) / 2 * h - t * k);
      long val2 = Math.abs((k + 2) / 2 * c + (k + 3) / 2 * h - t * (k + 2));
      if (val1 * (k + 2) <= val2 * k) {
        out.println(k);
      } else {
        out.println(k + 2);
      }
    }
  }
}
