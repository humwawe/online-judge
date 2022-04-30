package acwing.contest.weekly.c49;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int sum = 0;
    int min = (int) 1e6;
    int max = (int) -1e6;
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] > 0) {
        sum += a[i];
      }
      if (Math.abs(a[i]) % 2 == 1) {
        if (a[i] > 0) {
          min = Math.min(min, a[i]);
        } else if (a[i] < 0) {
          max = Math.max(max, a[i]);
        }

      }
    }
    if (sum % 2 == 1) {
      out.println(sum);
      return;
    }
    out.println(sum - Math.min(Math.abs(min), Math.abs(max)));

  }
}
