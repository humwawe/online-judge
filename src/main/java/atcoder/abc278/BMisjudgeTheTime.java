package atcoder.abc278;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMisjudgeTheTime {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int h = in.nextInt();
    int w = in.nextInt();
    boolean f = true;
    for (int i = h; i < h + 24; i++) {
      if (i != h) {
        f = false;
      }
      for (int j = f ? w : 0; j < 60; j++) {
        int x = i % 24;
        int y = j % 60;
        int a = x / 10;
        int b = x % 10;
        int c = y / 10;
        int d = y % 10;
        if (helper(a, b, c, d)) {
          out.println(x, y);
          return;
        }
      }
    }
  }

  private boolean helper(int a, int b, int c, int d) {
    int x = a * 10 + c;
    int y = b * 10 + d;
    if (x >= 0 && x < 24 && y >= 0 && y < 60) {
      return true;
    }
    return false;
  }
}
