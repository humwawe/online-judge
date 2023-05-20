package acwing.contest.weekly.c104;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextLong();
    long b = in.nextLong();

    out.println(helper(b) - helper(a - 1));
  }

  private int helper(long x) {
    int res = 0;
    for (int len = 1; len < 64; len++) {
      StringBuilder s = new StringBuilder("1".repeat(len));
      for (int i = len - 1; i >= 1; i--) {
        s.setCharAt(i, '0');
        if (Long.valueOf(s.toString(), 2) <= x) {
          res++;
        }
        s.setCharAt(i, '1');
      }
    }
    return res;
  }
}
