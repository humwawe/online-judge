package acwing.contest.weekly.c85;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] x = new int[2];
    int[] y = new int[2];
    for (int i = 0; i < n; i++) {
      int t = in.nextInt() - 1;
      int a = in.nextInt();
      int b = in.nextInt();
      x[t] += a;
      y[t] += b;
    }
    if (x[0] >= y[0]) {
      out.println("LIVE");
    } else {
      out.println("DEAD");
    }
    if (x[1] >= y[1]) {
      out.println("LIVE");
    } else {
      out.println("DEAD");
    }
  }
}
