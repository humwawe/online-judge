package acwing.contest.weekly.c89;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int s = 0;
    for (int i = 0; i < n; i++) {
      s += in.nextInt();
    }
    int res = 0;
    for (int i = 1; i <= 5; i++) {
      if ((s + i) % (n + 1) != 1) {
        res++;
      }
    }
    out.println(res);
  }
}
