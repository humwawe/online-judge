package acwing.contest.weekly.c25;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    for (int i = 0; i < n - 1; i++) {
      if (i % 2 == 0) {
        out.print("I hate that ");
      } else {
        out.print("I love that ");
      }
    }
    if (n % 2 == 0) {
      out.print("I love it");
    } else {
      out.print("I hate it");
    }
  }
}
