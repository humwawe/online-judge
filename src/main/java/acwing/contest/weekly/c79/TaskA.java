package acwing.contest.weekly.c79;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int sum = 0;
    for (int i = 1; ; i++) {
      sum += i;
      if (sum == n) {
        out.println("YES");
        return;
      } else if (sum > n) {
        out.println("NO");
        return;
      }
    }
  }
}
