package leetcode.c341;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  Graph graph;
  int[] fa;
  int[][] dp;
  int[] price;
  int[] cnt;

  public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
    graph = new Graph(n, edges.length);
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1]);
    }
    cnt = new int[n];
    fa = new int[n];
    dp = new int[n][2];
    this.price = price;
    for (int[] trip : trips) {
      Arrays.fill(fa, -1);
      int st = trip[0];
      int en = trip[1];
      dfs(st, st);
      int tmp = en;
      cnt[tmp]++;
      while (tmp != st) {
        tmp = fa[tmp];
        cnt[tmp]++;
      }
    }

    dfs2(0, 0);
    return Math.min(dp[0][0], dp[0][1]);

  }

  private void dfs2(int u, int p) {
    int sum1 = 0;
    int sum2 = 0;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs2(j, u);
      sum1 += Math.min(dp[j][0], dp[j][1]);
      sum2 += dp[j][0];
    }
    dp[u][0] = sum1 + cnt[u] * price[u];
    dp[u][1] = sum2 + cnt[u] * (price[u] / 2);
  }

  private void dfs(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      fa[j] = u;
      dfs(j, u);
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
