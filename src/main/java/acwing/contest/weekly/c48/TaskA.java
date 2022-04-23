package acwing.contest.weekly.c48;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int cnt = n;
    for (int i = 1; ; i++) {
      if (cnt < i) {
        out.println(i - 1);
        return;
      }
      if (i % m == 0) {
        cnt++;
      }
    }
  }
}
