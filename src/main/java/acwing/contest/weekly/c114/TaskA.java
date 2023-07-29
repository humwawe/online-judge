package acwing.contest.weekly.c114;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if ((n & (n - 1)) == 0) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}