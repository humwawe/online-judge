package acwing.contest.weekly.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int n;
  long k;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextLong();
    int res = helper(n, k);
    out.println(res);
  }

  private int helper(int n, long k) {
    long mid = (long) Math.pow(2, n) / 2;
    if (mid == k) {
      return n;
    }
    if (k > mid) {
      return helper(n - 1, k - mid);
    } else {
      return helper(n - 1, k);
    }
  }
}
