package acwing.contest.weekly.c99;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      b[i] = in.nextInt();
    }
    if (n == 1) {
      out.println(1);
      return;
    }
    int res = 2;
    int last = a[0];
    for (int i = 1; i < n - 1; i++) {
      if (last + b[i] < a[i]) {
        res++;
        last = a[i];
      } else {
        if (a[i] + b[i] < a[i + 1]) {
          res++;
          last = a[i] + b[i];
        } else {
          last = a[i];
        }
      }
    }
    out.println(res);
  }
}
