package acwing.contest.weekly.c101;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    double a = in.nextInt();
    double b = in.nextInt();
    double c = in.nextInt();
    double res1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    double res2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    out.printf("%.6f\n", Math.max(res1, res2));
    out.printf("%.6f\n", Math.min(res1, res2));
  }
}
