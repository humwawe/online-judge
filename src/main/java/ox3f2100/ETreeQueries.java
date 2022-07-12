package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class ETreeQueries {
  int N = (int) (2e5 + 5);
  int M = N * 2;
  int[] h = new int[N];
  int[] fa = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int[] dist = new int[N];
  int idx;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }

    dfs(1, 1);
    bfs();
    f:
    for (int q = 0; q < m; q++) {
      int k = in.nextInt();
      int[] a = new int[k];
      Integer[] idx = new Integer[k];
      for (int i = 0; i < k; i++) {
        a[i] = fa[in.nextInt()];
        idx[i] = i;
      }
      Arrays.sort(idx, (x, y) -> dist[a[y]] - dist[a[x]]);

      for (int i = 1; i < k; i++) {
        if (lca(a[idx[i]], a[idx[i - 1]]) != a[idx[i]]) {
          out.println("NO");
          continue f;
        }
      }

      out.println("YES");
    }

  }

  int T = 18;
  int[] d = new int[N];
  int[][] f = new int[N][T];

  void bfs() {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    d[1] = 1;
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (d[j] == 0) {
          d[j] = d[u] + 1;
          f[j][0] = u;
          for (int k = 1; k < T; k++) {
            f[j][k] = f[f[j][k - 1]][k - 1];
          }
          queue.add(j);
        }
      }
    }
  }

  private int lca(int a, int b) {
    if (d[a] < d[b]) {
      int t = a;
      a = b;
      b = t;
    }
    // 走到统一层
    for (int i = T - 1; i >= 0; i--) {
      if (d[f[a][i]] >= d[b]) {
        a = f[a][i];
      }
    }
    if (a == b) {
      return a;
    }
    for (int i = T - 1; i >= 0; i--) {
      if (f[a][i] != f[b][i]) {
        a = f[a][i];
        b = f[b][i];
      }
    }
    return f[a][0];
  }


  private void dfs(int u, int p) {
    fa[u] = p;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dist[j] = dist[u] + 1;
      dfs(j, u);
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
