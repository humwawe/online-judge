package acwing.contest.weekly.c104;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] res = new int[n];
    int[] a = in.nextInt(n);
    int[] max = new int[n + 1];
    for (int i = n - 1; i >= 0; i--) {
      max[i] = Math.max(max[i + 1], a[i]);
    }

    for (int i = 0; i < n; i++) {
      res[i] = Math.max(0, max[i + 1] - a[i] + 1);
    }
    out.println(res);
  }
}
