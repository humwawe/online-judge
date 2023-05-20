package acwing.contest.weekly.c104;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = in.nextInt();
    if (a % 2 == 1) {
      out.println(a / 2 + 1);
    } else {
      out.println(n / 2 - a / 2 + 1);
    }
  }
}
