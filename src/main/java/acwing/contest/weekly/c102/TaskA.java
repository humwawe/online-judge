package acwing.contest.weekly.c102;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = 0;
    int b = 0;
    for (int i = 0; i < n; i++) {
      a |= in.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b |= in.nextInt();
    }

    out.println(a + b);
  }
}
