package acwing.contest.weekly.c97;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int a = in.nextInt();
    int b = in.nextInt();
    out.println(Math.min(a, b), Math.abs(a - b) / 2);
  }
}
