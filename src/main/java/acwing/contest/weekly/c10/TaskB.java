package acwing.contest.weekly.c10;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum += a[i];
    }
    int res = 0;
    int tmp = 0;
    for (int i = 0; i < n - 1; i++) {
      tmp += a[i];
      if (2 * tmp == sum) {
        res++;
      }
    }
    out.println(res);
  }
}
