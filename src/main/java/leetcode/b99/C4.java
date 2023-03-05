package leetcode.b99;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class C4 {
  Graph graph;
  long base = (long) (1e5 + 5);
  Set<Long> set = new HashSet<>();
  int[] cnt, res;
  int ans = 0;
  int k;

  public int rootCount(int[][] edges, int[][] guesses, int k) {
    int n = edges.length + 1;
    graph = new Graph(n, n - 1);

    cnt = new int[n];
    res = new int[n];
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1]);
    }
    for (int[] guess : guesses) {
      set.add(base * guess[0] + guess[1]);
    }
    this.k = k;

    dfs1(0, 0);

    res[0] = cnt[0];
    if (res[0] >= k) {
      ans++;
    }

    dfs2(0, 0);

    return ans;
  }

  private void dfs2(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }

      res[j] = res[u];
      if (set.contains(base * u + j)) {
        res[j] -= 1;
      }
      if (set.contains(base * j + u)) {
        res[j] += 1;
      }
      if (res[j] >= k) {
        ans++;
      }
      dfs2(j, u);
    }
  }

  private void dfs1(int u, int p) {

    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs1(j, u);
      if (set.contains(base * u + j)) {
        cnt[u]++;
      }
      cnt[u] += cnt[j];
    }

  }

  class Graph {
    public int N, M;
    public int[] h;
    public int[] e;
    public int[] ne;
    public int[] w;
    int idx, n, m;
    // 是否有方向，默认无向边
    boolean flag;
    // 第i条边的from节点，e存的是to的节点
    public int[] fe;

    public Graph(int n, int m) {
      this(n, m, false);
    }

    public Graph(int n, int m, boolean f) {
      this.n = n;
      this.m = m;
      flag = f;
      N = n + 5;
      M = flag ? m + 5 : m * 2 + 5;

      h = new int[N];
      e = new int[M];
      ne = new int[M];
      w = new int[M];
      idx = 0;
      Arrays.fill(h, -1);

      fe = new int[M];
    }

    public void add(int a, int b) {
      add0(a, b);
      if (!flag) {
        add0(b, a);
      }
    }

    public void add(int a, int b, int c) {
      add0(a, b, c);
      if (!flag) {
        add0(b, a, c);
      }
    }

    private void add0(int a, int b) {
      add0(a, b, 0);
    }

    private void add0(int a, int b, int c) {
      fe[idx] = a;
      e[idx] = b;
      w[idx] = c;
      ne[idx] = h[a];
      h[a] = idx++;
    }
  }
}
