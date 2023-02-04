package acwing.contest.weekly.c89;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int x = in.nextInt();
    int y = in.nextInt();
    long[] f = new long[n + 1];
    Arrays.fill(f, (long) 1e18);
    f[0] = 0;
    for (int i = 1; i <= n; i++) {
      f[i] = Math.min(f[i], f[i - 1] + x);
      if (i % 2 == 0) {
        f[i] = Math.min(f[i], f[i / 2] + y);
      } else {
        f[i] = Math.min(f[i], f[(i + 1) / 2] + x + y);
      }
    }

    out.println(f[n]);
  }
}
