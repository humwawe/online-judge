package acwing.contest.weekly.c97;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int a = in.nextInt();
    long x = 0;
    for (int i = 0; i < n; i++) {
      int t = in.nextInt();
      x = x * a + t;
    }

    int m = in.nextInt();
    int b = in.nextInt();
    long y = 0;
    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      y = y * b + t;
    }
    if (x == y) {
      out.println("=");
    } else if (x > y) {
      out.println(">");
    } else {
      out.println("<");
    }
  }
}
