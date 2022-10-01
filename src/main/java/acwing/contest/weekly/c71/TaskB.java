package acwing.contest.weekly.c71;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    if (isp(n)) {
      out.println(1);
      return;
    }
    if (n % 2 == 0) {
      out.println(2);
      return;
    }
    if (isp(n - 2)) {
      out.println(2);
      return;
    }
    out.println(3);
  }

  private boolean isp(long n) {
    for (long i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
