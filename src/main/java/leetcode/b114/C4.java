package leetcode.b114;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  Graph graph;
  int[] v;
  int ans = 0;
  int k;

  public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
    v = values;
    this.k = k;
    graph = new Graph(n, n - 1);
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1]);
    }

    dfs(0, 0);
    return ans;
  }

  private void dfs(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      v[u] = (v[u] + v[j]) % k;
    }
    if (v[u] % k == 0) {
      ans++;
      v[u] = 0;
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
