package atcoder.abc305;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class EArtGalleryOnGraph {
  int ans = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    Graph graph = new Graph(n, m);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      graph.add(a, b);
    }

    int[][] guards = new int[k][2];

    for (int i = 0; i < k; i++) {
      guards[i][0] = in.nextInt() - 1;
      guards[i][1] = in.nextInt();
    }
    boolean[] dijkstra = dijkstra(graph, guards);
    out.println(ans);
    for (int i = 0; i < n; i++) {
      if (dijkstra[i]) {
        out.print(i + 1, "");
      }
    }
    out.println();
  }

  public boolean[] dijkstra(Graph graph, int[][] g) {
    long[] dist = new long[graph.N];
    Arrays.fill(dist, -1);
    boolean[] vis = new boolean[graph.N];
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>((x, y) -> Long.compare(y[1], x[1]));
    for (int[] gs : g) {
      priorityQueue.add(new long[]{gs[0], gs[1]});
      dist[gs[0]] = dist[gs[1]];
    }
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[1];
      int u = (int) poll[0];
      if (vis[u]) {
        continue;
      }
      vis[u] = true;
      ans++;
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (dist[j] < d - 1) {
          dist[j] = d - 1;
          priorityQueue.add(new long[]{j, dist[j]});
        }
      }
    }
    return vis;
  }
}
