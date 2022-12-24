package acwing.contest.weekly.c83;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n);
    boolean[] vis = new boolean[n];
    Integer[] b = new Integer[m];
    for (int i = 0; i < m; i++) {
      b[i] = in.nextInt() - 1;
      vis[b[i]] = true;
    }
    long x = 0;
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        x += a[i];
      }
    }

    Arrays.sort(b, (xx, yy) -> a[yy] - a[xx]);

    for (int i = 0; i < m; i++) {
      if (a[b[i]] > x) {
        x += a[b[i]];
      } else {
        x *= 2;
      }
    }

    out.println(x);
  }
}
