package codeforces.c788;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CWhereIsThePizza {
  int[] a;
  int[] b;
  int[] c;
  int[] ia;
  int[] ib;

  int n;
  boolean[] vis;
  boolean f = false;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n + 1];
    ia = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
      ia[a[i]] = i;
    }
    b = new int[n + 1];
    ib = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      b[i] = in.nextInt();
      ib[b[i]] = i;
    }
    c = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      c[i] = in.nextInt();
      if (c[i] == 0 && a[i] == b[i]) {
        c[i] = a[i];
      }
    }
    vis = new boolean[n + 1];
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      f = false;
      if (!vis[i]) {
        dfs(i);
        if (!f) {
          cnt++;
        }
      }
    }
    int mod = (int) (1e9 + 7);
    long res = 1;
    for (int i = 0; i < cnt; i++) {
      res = res * 2 % mod;
    }
    out.println(res);
  }

  private void dfs(int i) {
    if (vis[i]) {
      return;
    }
    if (c[i] != 0) {
      f = true;
    }
    vis[i] = true;
    int na = a[i];
    int nb = b[i];
    dfs(ib[na]);
    dfs(ia[nb]);
  }
}
