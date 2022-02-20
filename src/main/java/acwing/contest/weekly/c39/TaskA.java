package acwing.contest.weekly.c39;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int b = 0;
    int c = 0;
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      if (a > 0) {
        c += a;
      } else {
        b += a;
      }
    }
    out.println(c - b);
  }
}
