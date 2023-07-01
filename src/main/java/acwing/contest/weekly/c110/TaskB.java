package acwing.contest.weekly.c110;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long x = in.nextInt();
    for (long i = 1; i * i <= x; i++) {
      long last = x - i * (i + 1) / 2;
      if (last <= 0) {
        break;
      }
      long y = (long) Math.sqrt(2 * last);

      if (y * (y + 1) == 2 * last) {
        out.println("YES");
        return;
      }
      if (y * (y - 1) == 2 * last) {
        out.println("YES");
        return;
      }
    }
    out.println("NO");
  }
}
