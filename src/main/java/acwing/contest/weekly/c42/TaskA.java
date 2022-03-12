package acwing.contest.weekly.c42;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    double x = Double.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      double a = in.nextDouble();
      double b = in.nextDouble();
      x = Math.min(x, a / b);
    }

    out.printf("%.6f", m * x);
  }
}
