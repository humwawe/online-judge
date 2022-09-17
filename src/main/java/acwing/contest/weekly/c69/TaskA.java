package acwing.contest.weekly.c69;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x = in.nextInt();
    int y = in.nextInt();
    int d = y - x;
    int a = in.nextInt();
    int b = in.nextInt();
    int t = a + b;
    if (d % t != 0) {
      out.println(-1);
    } else {
      out.println(d / t);
    }
  }
}
