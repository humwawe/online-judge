package acwing.contest.weekly.c91;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] x = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();

      for (int j = a; j <= b; j++) {
        x[j]++;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (x[i] != 1) {
        out.println(i, x[i]);
        return;
      }
    }
    out.println("OK");
  }
}
