package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BGregAndGraph {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] d = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        d[i][j] = in.nextInt();
      }
    }
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    boolean[] vis = new boolean[n + 1];
    long[] res = new long[n];
    for (int k = n - 1; k >= 0; k--) {
      vis[a[k]] = true;
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          d[i][j] = Math.min(d[i][j], d[i][a[k]] + d[a[k]][j]);
        }
      }
      long sum = 0;
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (vis[i] && vis[j]) {
            sum += d[i][j];
          }
        }
      }
      res[k] = sum;
    }
    out.println(res);
  }
}
