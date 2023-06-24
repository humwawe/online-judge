package acwing.contest.weekly.c109;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n % 2 == 1) {
      out.println(0);
    } else {
      out.println(1L << (n / 2));
    }
  }
}
