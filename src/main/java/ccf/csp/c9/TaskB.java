package ccf.csp.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    for (long i = 100; ; i += 100) {
      if (check(i, x)) {
        out.println(i);
        return;
      }
    }
  }

  private boolean check(long t, long x) {
    int res = 0;
    long cur = t;
    if (cur >= 3500) {
      cur -= 3500;
    } else {
      cur = 0;
    }
    if (cur >= 1500) {
      res += 1500 / 100 * 3;
      cur -= 1500;
    } else {
      res += cur / 100 * 3;
      cur = 0;
    }
    if (cur >= 3000) {
      res += 3000 / 100 * 10;
      cur -= 3000;
    } else {
      res += cur / 100 * 10;
      cur = 0;
    }
    if (cur >= 4500) {
      res += 4500 / 100 * 20;
      cur -= 4500;
    } else {
      res += cur / 100 * 20;
      cur = 0;
    }

    if (cur >= 35000 - 9000) {
      res += (35000 - 9000) / 100 * 25;
      cur -= 35000 - 9000;
    } else {
      res += cur / 100 * 25;
      cur = 0;
    }
    if (cur >= 55000 - 35000) {
      res += (55000 - 35000) / 100 * 30;
      cur -= 55000 - 35000;
    } else {
      res += cur / 100 * 30;
      cur = 0;
    }
    if (cur >= 80000 - 55000) {
      res += (80000 - 55000) / 100 * 35;
      cur -= 80000 - 55000;
    } else {
      res += cur / 100 * 35;
      cur = 0;
    }
    if (cur > 0) {
      res += cur / 100 * 45;
    }
    return t - res == x;
  }
}
