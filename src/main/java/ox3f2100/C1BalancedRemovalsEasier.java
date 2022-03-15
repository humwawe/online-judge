package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class C1BalancedRemovalsEasier {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    int[] z = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.nextInt();
      y[i] = in.nextInt();
      z[i] = in.nextInt();
    }
    boolean[] vis = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (vis[i]) {
        continue;
      }
      int min = 0;
      int d = Integer.MAX_VALUE;
      for (int j = i + 1; j < n; j++) {
        if (vis[j]) {
          continue;
        }

        int t = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]) + Math.abs(z[i] - z[j]);
        if (t < d) {
          min = j;
          d = t;
        }
      }
      out.println(i + 1, min + 1);
      vis[i] = true;
      vis[min] = true;
    }
  }
}
