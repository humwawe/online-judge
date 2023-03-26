package leetcode.c338;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class C4 {

  public int collectTheCoins(int[] coins, int[][] edges) {
    int n = coins.length;
    int[] deg = new int[n];
    Graph graph = new Graph(n, n - 1);

    for (int[] edge : edges) {
      graph.add(edge[0], edge[1]);
      deg[edge[0]]++;
      deg[edge[1]]++;
    }

    boolean[] vis = new boolean[n];
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (deg[i] == 1 && coins[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      vis[u] = true;
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (--deg[j] == 1 && coins[j] == 0) {
          queue.add(j);
        }
      }
    }

    for (int k = 0; k < 2; k++) {
      for (int i = 0; i < n; i++) {
        if (deg[i] == 1 && !vis[i]) {
          queue.add(i);
        }
      }
      while (!queue.isEmpty()) {
        Integer u = queue.poll();
        vis[u] = true;
        for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
          int j = graph.e[i];
          --deg[j];
        }
      }
    }
    int res = 0;
    for (int[] edge : edges) {
      if (!vis[edge[0]] && !vis[edge[1]]) {
        res += 2;
      }
    }
    return res;

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
