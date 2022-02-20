package acwing.contest.weekly.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    out.println(n);
    for (int i = 1; i <= n; i++) {
      out.print(i + " ");
    }
    out.println();
  }
}
