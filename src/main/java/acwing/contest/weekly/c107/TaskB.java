package acwing.contest.weekly.c107;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long res = 0;
    for (int i = 1; i <= n; i++) {
      res += (m + i) / 5 - (1 + i + 4) / 5 + 1;
    }
    out.println(res);
  }
}
