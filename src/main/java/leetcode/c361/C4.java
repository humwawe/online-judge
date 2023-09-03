package leetcode.c361;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class C4 {
  Graph graph;
  int[][] cnt;
  int[] d;
  int[][] f;
  int T = 18;

  public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
    graph = new Graph(n, n - 1);
    cnt = new int[n][26];
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1], edge[2] - 1);
    }

    d = new int[n];
    f = new int[n][T];

    bfs();
    int[] res = new int[queries.length];
    for (int i = 0, queriesLength = queries.length; i < queriesLength; i++) {
      int[] query = queries[i];
      int a = query[0];
      int b = query[1];
      int c = lca(a, b);
      int t = 0;
      for (int j = 0; j < 26; j++) {
        t = Math.max(t, distCnt(a, b, c, j));
      }
      res[i] = dist(a, b, c) - t;
    }
    return res;
  }


  void bfs() {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    d[0] = 1;
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (d[j] == 0) {
          d[j] = d[u] + 1;
          for (int k = 0; k < 26; k++) {
            cnt[j][k] = cnt[u][k];

          }
          cnt[j][graph.w[i]]++;
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

  private int dist(int a, int b, int c) {
    return d[a] + d[b] - 2 * d[c];
  }

  private int distCnt(int a, int b, int c, int j) {
    return cnt[a][j] + cnt[b][j] - 2 * cnt[c][j];
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
