package leetcode.c369;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  Graph graph;
  int n, k;
  int[] coins;
  int[] arr;
  Integer[][] memo;

  public int maximumPoints(int[][] edges, int[] coins, int k) {
    n = coins.length;
    this.coins = coins;
    this.k = k;
    memo = new Integer[n][17];
    arr = new int[17];
    arr[0] = 1;
    for (int i = 1; i < 17; i++) {
      arr[i] = arr[i - 1] * 2;
    }
    graph = new Graph(n, 2 * n);
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1]);
    }

    return Math.max(dfs(0, 0, 0) + coins[0] - k, dfs(0, 0, 1) + coins[0] / 2);
  }

  private int dfs(int u, int p, int cnt) {
    if (cnt > 15) {
      return 0;
    }
    if (memo[u][cnt] != null) {
      return memo[u][cnt];
    }
    int res = 0;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      res += Math.max(dfs(j, u, cnt) + coins[j] / arr[cnt] - k, dfs(j, u, cnt + 1) + coins[j] / arr[cnt + 1]);
    }
    return memo[u][cnt] = res;
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
