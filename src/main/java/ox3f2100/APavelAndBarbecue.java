package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APavelAndBarbecue {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    int[] b = new int[n];
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
      if (b[i] == 1) {
        cnt++;
      }
    }
    boolean[] vis = new boolean[n + 1];
    int res = 0;
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        dfs(i, a, vis);
        res++;
      }
    }
    if (res == 1) {
      res = 0;
    }
    if (cnt % 2 == 0) {
      out.println(res + 1);
    } else {
      out.println(res);
    }

  }

  private void dfs(int i, int[] a, boolean[] vis) {
    if (vis[i]) {
      return;
    }
    vis[i] = true;
    dfs(a[i], a, vis);
  }
}
