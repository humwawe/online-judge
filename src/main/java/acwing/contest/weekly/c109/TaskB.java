package acwing.contest.weekly.c109;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[][] a = new int[k][2];
    for (int i = 0; i < k; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }
    int dis = -1;
    int inf = (int) 1e8;
    int[] res = new int[2];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        int t = inf;
        for (int l = 0; l < k; l++) {
          t = Math.min(t, Math.abs(a[l][0] - i) + Math.abs(a[l][1] - j));
        }
        if (t > dis) {
          res[0] = i;
          res[1] = j;
          dis = t;
        }
      }
    }
    out.println(res);
  }
}
