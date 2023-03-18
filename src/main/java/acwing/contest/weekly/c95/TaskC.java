package acwing.contest.weekly.c95;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int min = (int) (1e9 + 5);
    for (int i = 1; i < n; i++) {
      min = Math.min(min, a[i]);
    }

    if (a[0] <= min) {
      out.println("Bob");
    } else {
      out.println("Alice");
    }
  }
}
