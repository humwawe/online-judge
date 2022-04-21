package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DHexagons {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long x = in.nextInt();
    long y = in.nextInt();
    int[] c = new int[7];
    for (int i = 1; i <= 6; i++) {
      c[i] = in.nextInt();
    }
    c[1] = Math.min(c[1], c[6] + c[2]);
    c[2] = Math.min(c[2], c[1] + c[3]);
    c[3] = Math.min(c[3], c[2] + c[4]);
    c[4] = Math.min(c[4], c[3] + c[5]);
    c[5] = Math.min(c[5], c[4] + c[6]);
    c[6] = Math.min(c[6], c[5] + c[1]);
    if (x >= 0 && y >= 0) {
      if (x > y) {
        out.println(y * c[1] + (x - y) * c[6]);
      } else {
        out.println(x * c[1] + (y - x) * c[2]);
      }
    } else if (x <= 0 && y <= 0) {
      if (x < y) {
        out.println(-y * c[4] - (x - y) * c[3]);
      } else {
        out.println(-x * c[4] - (y - x) * c[5]);
      }
    } else if (x >= 0) {
      out.println(x * c[6] - y * c[5]);
    } else {
      out.println(-x * c[3] + y * c[2]);
    }
  }
}
