package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CAMistOfFlorescence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int[] c = new int[4];
    for (int i = 0; i < 4; i++) {
      c[i] = in.nextInt() - 1;
    }
    out.println(32, 50);
    for (int i = 0; i < 1600; i++) {
      int x = i / 400;
      int y = (x + 1) % 4;
      if (i % 2 == 0 && i / 50 % 2 == 0 && 400 * x <= i && i < 400 * x + 2 * c[y] + 50 * (c[y] / 25)) {
        x = y;
      }
      out.print((char) ('A' + x));
      if (i % 50 == 49) {
        out.println();
      }
    }
  }
}
