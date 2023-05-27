package acwing.contest.weekly.c105;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int res = 0;
    for (int i = 1; i < n - 1; i++) {
      if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
        res++;
      }
      if (a[i] < a[i - 1] && a[i] < a[i + 1]) {
        res++;
      }
    }
    out.println(res);
  }
}
