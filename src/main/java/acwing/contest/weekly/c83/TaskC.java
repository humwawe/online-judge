package acwing.contest.weekly.c83;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int min = n / 2;
    if (min > m) {
      out.println(-1);
      return;
    }

    if (n == 1) {
      if (m != 0) {
        out.println(-1);
      } else {
        out.println(1);
      }
      return;
    }

    int[] a = new int[n];

    int need = m - min + 1;

    a[0] = 1 * need;
    a[1] = 2 * need;
    for (int i = 2; i < n; i++) {
      a[i] = a[1] + i - 1;
    }
    out.println(a);
  }
}
