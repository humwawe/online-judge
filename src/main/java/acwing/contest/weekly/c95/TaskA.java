package acwing.contest.weekly.c95;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int x1 = in.nextInt();
    int y1 = in.nextInt();
    int x2 = in.nextInt();
    int y2 = in.nextInt();
    out.println(Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)));
  }
}
