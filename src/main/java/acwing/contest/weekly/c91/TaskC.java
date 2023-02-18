package acwing.contest.weekly.c91;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  int[][] a;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextInt();
      }
    }
    int l = 1;
    int r = (int) 1e9;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    out.println(l);
  }

  private boolean check(int mid) {
    boolean[] vis = new boolean[m];
    boolean f = false;
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int j = 0; j < m; j++) {
        if (a[i][j] >= mid) {
          vis[j] = true;
          cnt++;
        }
      }
      if (cnt >= 2) {
        f = true;
      }
    }
    for (int i = 0; i < m; i++) {
      if (!vis[i]) {
        return false;
      }
    }
    return f;
  }
}
