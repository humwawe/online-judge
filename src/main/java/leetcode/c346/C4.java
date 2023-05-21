package leetcode.c346;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C4 {
  Graph graph;
  long inf = (long) 1e17;


  public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
    graph = new Graph(n, n * n / 2);
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1], edge[2]);
    }

    long[] dist = dijkstra(graph, source, true);
    if (dist[destination] < target) {
      return new int[][]{};
    }
    if (dist[destination] == target) {
      int[][] res = new int[edges.length][3];
      for (int i = 0; i < edges.length; i++) {
        res[i][0] = edges[i][0];
        res[i][1] = edges[i][1];
        res[i][2] = edges[i][2];
        if (res[i][2] == -1) {
          res[i][2] = (int) 2e9;
        }
      }
      return res;
    }

    dist = dijkstra(graph, source, false);
    if (dist[destination] > target) {
      return new int[][]{};
    }

    if (dist[destination] == target) {
      int[][] res = new int[edges.length][3];
      for (int i = 0; i < edges.length; i++) {
        res[i][0] = edges[i][0];
        res[i][1] = edges[i][1];
        res[i][2] = edges[i][2];
        if (res[i][2] == -1) {
          res[i][2] = 1;
        }
      }
      return res;
    }


    long[] dist2 = dijkstra(graph, destination, false);
    int[][] res = new int[edges.length][3];
    for (int i = 0; i < edges.length; i++) {
      res[i][0] = edges[i][0];
      res[i][1] = edges[i][1];
      res[i][2] = edges[i][2];
      if (res[i][2] == -1) {
        res[i][2] = 1;
      }
    }
    for (int i = 0; i < edges.length; i++) {
      if (edges[i][2] == -1) {
        int a = edges[i][0];
        int b = edges[i][1];
        long l1 = dist[a] + dist2[b];
        long l2 = dist[b] + dist2[a];
        long v = (target - Math.min(l1, l2));
        res[i][2] = v >= 1 ? (int) v : 1;
        if (res[i][2] > 1) {
          graph.w[2 * i] = graph.w[2 * i ^ 1] = res[i][2];
          dist = dijkstra(graph, source, false);
          dist2 = dijkstra(graph, destination, false);
          if (dist[destination] == target) {
            return res;
          }
        }
      }
    }

    return new int[][]{};
  }


  public long[] dijkstra(Graph graph, int s, boolean f) {
    long[] dist = new long[graph.N];
    boolean[] vis = new boolean[graph.N];
    Arrays.fill(dist, inf);
    dist[s] = 0;
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new long[]{0, s});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int u = (int) poll[1];
      if (vis[u]) {
        continue;
      }
      vis[u] = true;
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (f && graph.w[i] == -1) {
          continue;
        }
        if (dist[j] > d + Math.abs(graph.w[i])) {
          dist[j] = d + Math.abs(graph.w[i]);
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
    }
    return dist;
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
