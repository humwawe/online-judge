package acwing.contest.weekly.c110;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int s = in.nextInt();
    int cur = 0;
    for (int i = 0; i < n; i++) {
      cur += in.nextInt();
    }
    if (cur == s) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}
