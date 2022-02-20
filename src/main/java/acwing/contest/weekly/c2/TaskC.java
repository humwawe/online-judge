package acwing.contest.weekly.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  int i, j, tmp;
  boolean f = false;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = n / 3;
    int b = n / 5;
    for (i = 0; i <= a; i++) {
      for (j = 0; j <= b; j++) {
        tmp = n - 3 * i - 5 * j;
        if (tmp < 0) {
          break;
        }
        if (tmp % 7 == 0) {
          out.println(i + " " + j + " " + tmp / 7);
          f = true;
          return;
        }
      }
    }
    out.println(-1);
  }
}
