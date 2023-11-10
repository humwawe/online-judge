package ccf.csp.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int[] mon;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int y = in.nextInt();
    int d = in.nextInt();
    mon = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for (int i = 1; i <= 12; i++) {
      if (getDay(y, i) < d) {
        d -= getDay(y, i);
      } else {
        out.println(i);
        out.println(d);
        break;
      }
    }
  }

  int getDay(int y, int m) {
    if (m == 2) {
      if (isH(y)) {
        return mon[m] + 1;
      }
    }
    return mon[m];
  }

  private boolean isH(int y) {
    return y % 400 == 0 || y % 4 == 0 && y % 100 != 0;
  }
}
