package ccf.csp.c10;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskD {
  Graph graph;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    graph = new Graph(n, m * 2);

    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    long[] dijkstra = dijkstra(graph, 1);
    out.println(dijkstra[n]);

  }

  public long inf = (long) 1e17;

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
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = graph.h[v]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (dist[j] > Math.max(d, graph.w[i])) {
          dist[j] = Math.max(d, graph.w[i]);
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
    }
    return dist;
  }

}
