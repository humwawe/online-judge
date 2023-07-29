package acwing.contest.weekly.c114;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int p = in.nextInt();
    long sum = 0;
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }

    long tmp = 0;
    long res = 0;
    for (int i = 0; i < n - 1; i++) {
      tmp += a[i];
      res = Math.max(res, tmp % p + (sum - tmp) % p);
    }
    out.println(res);
  }
}
