package acwing.contest.weekly.c93;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  int n;
  long x;
  int inf = (int) 1e8;
  int ans = inf;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    x = in.nextLong();
    dfs(x, 0);
    out.println(ans == inf ? -1 : ans);
  }

  private void dfs(long x, int res) {
    if (res >= ans) {
      return;
    }
    int len = 0;
    long t = x;
    boolean[] vis = new boolean[10];
    while (t > 0) {
      int a = (int) (t % 10);
      t = t / 10;
      len++;
      if (a == 1 || a == 0) {
        continue;
      }
      vis[a] = true;
    }
    if (len > n || n - len >= ans - res) {
      return;
    }
    if (len == n) {
      ans = Math.min(ans, res);
      return;
    }
    for (int i = 9; i >= 2; i--) {
      if (vis[i]) {
        dfs(x * i, res + 1);
      }
    }
  }
}
