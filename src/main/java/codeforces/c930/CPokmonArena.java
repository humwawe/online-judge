package codeforces.c930;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.*;

public class CPokmonArena {
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    int[] c = in.nextInt(n);
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt(m);
    }
    Graph graph = new Graph(n * m + n, 5 * (n * m + n), true);

    for (int j = 0; j < m; j++) {
      List<int[]> tmp = new ArrayList<>();
      for (int i = 1; i < n; i++) {
        tmp.add(new int[]{a[i][j], i});
      }
      tmp.sort((x, y) -> y[0] - x[0]);
      graph.add(0, p(tmp.get(0)[1], j, 0), Math.max(0, a[0][j] - tmp.get(0)[0]));
      graph.add(p(tmp.get(0)[1], j, 0), p2(tmp.get(0)[1]), c[tmp.get(0)[1]]);

      graph.add(p2(tmp.get(0)[1]), p(tmp.get(0)[1], j, 0), 0);


      for (int i = 0; i < n - 2; i++) {
        int[] x = tmp.get(i);
        int[] y = tmp.get(i + 1);
        graph.add(0, p(y[1], j, 0), Math.max(0, a[0][j] - y[0]));

        graph.add(p(x[1], j, 0), p(y[1], j, 0), x[0] - y[0]);
        graph.add(p(y[1], j, 0), p(x[1], j, 0), 0);

        graph.add(p(y[1], j, 0), p2(y[1]), c[y[1]]);
        graph.add(p2(y[1]), p(y[1], j, 0), 0);
      }
    }

    Dijkstra dijkstra = new Dijkstra();
    long[] res = dijkstra.dijkstra(graph, 0);
    out.println(res[p2(n - 1)]);

  }

  private int p(int i, int j, int f) {
    return (i - (1 - f)) * m + (j + 1);
  }

  private int p2(int i) {
    return n * m + i;
  }

  class Dijkstra {
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
        int u = (int) poll[1];
        if (vis[u]) {
          continue;
        }
        vis[u] = true;
        for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
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
}
