package acwing.contest.weekly.c43;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long sum = in.nextLong();
    int[] a = new int[n];

    long max = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      max += a[i];
    }

    long[] res = new long[n];
    for (int i = 0; i < n; i++) {
      max -= a[i];
      long x = Math.max(1, sum - max);
      long y = Math.min(a[i], sum - (n - 1));
      res[i] = Math.max(0, a[i] - (y - x + 1));
      max += a[i];
    }
    out.println(res);
  }
}
