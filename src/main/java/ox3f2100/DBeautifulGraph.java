package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DBeautifulGraph {
  int[] h;
  int[] e;
  int[] ne;
  int idx;
  int n, m;
  int mod = 998244353;
  int[] c1;
  int[] c2;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    h = new int[n + 5];
    c1 = new int[n + 5];
    c2 = new int[n + 5];
    e = new int[2 * m + 5];
    ne = new int[2 * m + 5];

    Arrays.fill(h, -1);
    idx = 0;
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }
    long res = 1;
    for (int i = 1; i <= n; i++) {
      if (c1[i] == 0) {
        res = (res * (dfs1(i, i, 2) + dfs2(i, i, 1))) % mod;
      }
    }

    out.println(res % mod);
  }

  private long dfs1(int u, int p, int v) {
    long res = 1;
    c1[u] = v;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      if (c1[j] != 0 && c1[j] == c1[u]) {
        return 0;
      }
      if (c1[j] == 0) {
        res = res * dfs1(j, u, 3 - v) % mod;
      }
    }

    if (v == 1) {
      res = res * 2 % mod;
    }
    return res;
  }

  private long dfs2(int u, int p, int v) {
    long res = 1;
    c2[u] = v;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      if (c2[j] != 0 && c2[j] == c2[u]) {
        return 0;
      }
      if (c2[j] == 0) {
        res = res * dfs2(j, u, 3 - v) % mod;
      }
    }

    if (v == 1) {
      res = res * 2 % mod;
    }
    return res;
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
