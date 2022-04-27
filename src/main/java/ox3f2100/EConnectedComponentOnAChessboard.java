package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EConnectedComponentOnAChessboard {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int b = in.nextInt();
    int w = in.nextInt();
    if (b == w) {
      out.println("YES");
      for (int i = 0; i < 2 * b; i += 2) {
        out.println(1, i + 1);
        out.println(1, i + 2);
      }
      return;
    }
    boolean f = false;
    if (b < w) {
      f = true;
      int t = b;
      b = w;
      w = t;
    }

    if (b > 3 * w + 1) {
      out.println("No");
      return;
    }
    out.println("YES");
    int i = 3;
    if (f) {
      i = 2;
    }
    for (int j = 0; j < w; j++) {
      out.println(2, i + j * 2);
      out.println(2, i + 1 + j * 2);
    }
    out.println(2, i + w * 2);
    int last = b - w - 1;

    for (i++; ; i += 2) {
      if (last == 0) {
        break;
      }
      out.println(1, i);
      last--;
      if (last == 0) {
        break;
      }
      out.println(3, i);
      last--;
    }

  }
}
