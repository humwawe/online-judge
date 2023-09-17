package leetcode.b113;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  Graph graph;
  int[] f;
  int[] res;

  public int[] minEdgeReversals(int n, int[][] edges) {
    graph = new Graph(n, 2 * n, true);
    f = new int[n];
    res = new int[n];
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1], 1);
      graph.add(edge[1], edge[0], 0);
    }

    dfs(0, 0);
    res[0] = f[0];

    dfs2(0, 0);
    return res;
  }

  private void dfs2(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      res[j] = res[u];
      if (graph.w[i] == 1) {
        res[j] += 1;
      } else {
        res[j] -= 1;
      }
      dfs2(j, u);
    }

  }

  private void dfs(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      if (graph.w[i] == 0) {
        f[u]++;
      }
      f[u] += f[j];
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
    // 对第i条边 a->b c 可分别为fe[i] e[i] w[i] 取到该点
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
