package leetcode.b102;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C4 {

  MyG myG;

  public C4(int n, int[][] edges) {
    myG = new MyG(n, edges.length + 105, true);
    for (int[] edge : edges) {
      myG.add(edge[0], edge[1], edge[2]);
    }
  }

  public void addEdge(int[] edge) {
    myG.add(edge[0], edge[1], edge[2]);
  }

  public int shortestPath(int node1, int node2) {
    long[] dijkstra = dijkstra(myG, node1);
    return dijkstra[node2] == inf ? -1 : (int) dijkstra[node2];

  }

  public long inf = (long) 1e17;

  public long[] dijkstra(MyG graph, int s) {
    long[] dist = new long[graph.N];
    boolean[] vis = new boolean[graph.N];
    Arrays.fill(dist, inf);
    dist[s] = 0;
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new long[]{0, s});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int v = (int) poll[1];
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = graph.h[v]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (dist[j] > d + graph.w[i]) {
          dist[j] = d + graph.w[i];
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
    }
    return dist;
  }

  class MyG {
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

    public MyG(int n, int m) {
      this(n, m, false);
    }

    public MyG(int n, int m, boolean f) {
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
