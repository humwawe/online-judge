package acwing.contest.weekly.c46;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int k1 = in.nextInt();
    int k2 = in.nextInt();
    if (n1 <= n2) {
      out.println("Second");
    } else {
      out.println("First");
    }
  }
}
