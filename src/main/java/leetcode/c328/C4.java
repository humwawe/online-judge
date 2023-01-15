package leetcode.c328;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {

  public static void main(String[] args) {
    C4 c4 = new C4();
    System.out.println(c4.maxOutput(3, new int[][]{{0, 1}, {1, 2}}, new int[]{1, 1, 1}));

  }

  Graph graph;
  int[] price;
  long[] dep1, dep2, up;
  int[] to1, to2;
  long ans;

  public long maxOutput(int n, int[][] edges, int[] price) {

    dep1 = new long[n];
    dep2 = new long[n];
    to1 = new int[n];
    to2 = new int[n];
    up = new long[n];
    this.price = price;
    graph = new Graph(n, n - 1);
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1]);
    }
    dfs1(0, 0);


    dfs2(0, 0);

    return ans;
  }

  private void dfs2(int u, int p) {

    ans = Math.max(ans, Math.max(dep1[u], up[u] + price[u]) - price[u]);

    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      long tmp = 0;
      if (to1[u] == j) {
        tmp = Math.max(dep2[u], up[u] + price[u]);
      } else {
        tmp = Math.max(dep1[u], up[u] + price[u]);
      }
      up[j] = tmp;

      dfs2(j, u);
    }
  }

  private void dfs1(int u, int p) {
    dep1[u] = price[u];
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs1(j, u);
      if (dep1[j] + price[u] >= dep1[u]) {
        dep2[u] = dep1[u];
        to2[u] = to1[u];
        dep1[u] = dep1[j] + price[u];
        to1[u] = j;
      } else if (dep1[j] + price[u] >= dep2[u]) {
        dep2[u] = dep1[j] + price[u];
        to2[u] = j;
      }
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