package acwing.contest.weekly.c107;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String x = String.valueOf(n);
    int c = x.charAt(x.length() - 1) - '0';
    if (c <= 4) {
      out.println(n - c);
    } else {
      out.println(n + (10 - c));
    }
  }
}
