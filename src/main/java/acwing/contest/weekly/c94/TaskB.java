package acwing.contest.weekly.c94;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.*;

public class TaskB {
  int n, m;
  Graph graph;
  Set<Long>[] sets;
  public long inf = (long) 1e17;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    graph = new Graph(n, m);
    sets = new Set[n + 1];
    Arrays.setAll(sets, e -> new HashSet<>());
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    for (int i = 1; i <= n; i++) {
      int k = in.nextInt();
      for (int j = 0; j < k; j++) {
        long x = in.nextInt();
        sets[i].add(x);
      }
    }
    long[] dijkstra = dijkstra(graph, 1);
    out.println(dijkstra[n] == inf ? -1 : dijkstra[n]);

  }

  public long[] dijkstra(Graph graph, int s) {
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
      boolean f = false;
      while (sets[v].contains(d)) {
        d++;
        f = true;
      }
      if (f) {
        priorityQueue.add(new long[]{d, v});
        continue;
      }
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

}
