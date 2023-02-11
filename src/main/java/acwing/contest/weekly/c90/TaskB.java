package acwing.contest.weekly.c90;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int m = in.nextInt();
    int s = in.nextInt();
    if (m == 1 && s == 0) {
      out.println(0, 0);
      return;
    }
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    int cur = 0;
    for (int i = 0; i < m; i++) {
      int j = 0;
      if (i == 0) {
        j = 1;
      }
      boolean f = false;
      for (; j <= 9; j++) {
        int min = cur + j;
        int max = cur + j + 9 * (m - i - 1);
        if (min <= s && max >= s) {
          f = true;
          break;
        }
      }
      if (f) {
        sb1.append(j);
        cur += j;
      } else {
        out.println(-1, -1);
        return;
      }
    }

    cur = 0;
    for (int i = 0; i < m; i++) {
      int lim = 0;
      if (i == 0) {
        lim = 1;
      }
      boolean f = false;
      int j = 9;
      for (; j >= lim; j--) {
        int min = cur + j;
        int max = cur + j + 9 * (m - i - 1);
        if (min <= s && max >= s) {
          f = true;
          break;
        }
      }
      if (f) {
        sb2.append(j);
        cur += j;
      } else {
        out.println(-1, -1);
        return;
      }
    }
    out.println(sb1, sb2);
  }
}
