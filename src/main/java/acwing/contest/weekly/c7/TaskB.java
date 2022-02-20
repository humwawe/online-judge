package acwing.contest.weekly.c7;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long n = in.nextLong();
    long k = in.nextLong();
    StringBuilder sb = new StringBuilder();
    int cnt = 2;
    for (int i = 1; i <= n; i++) {
      long t = 0;
      if (cnt == 2) {
        t = (n - i) * (n - i - 1) / 2;
      } else if (cnt == 1) {
        t = n - i;
      }
      if (cnt == 0 || t >= k) {
        sb.append("a");
      } else {
        sb.append("b");
        k -= t;
        cnt--;
      }
    }
    out.println(sb.toString());

  }
}
