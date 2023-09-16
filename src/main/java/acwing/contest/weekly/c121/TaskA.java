package acwing.contest.weekly.c121;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long x = in.nextLong();
    long y = in.nextLong();
    long z = in.nextLong();
    out.println((z - y) / x * x + y);
  }
}
