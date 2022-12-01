package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Task1044 {
  int inf = (int) 1e8;
  int mod = (int) (1e9 + 7);
  long[] f, g;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    Graph graph = new Graph(n, m, true);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    long[] res = new long[m];
    for (int i = 0; i < n; i++) {
      f = new long[n];
      g = new long[n];

      long[] dist = dijkstra(graph, i);
      dfs(graph, i, dist);

      for (int j = 0; j < m; j++) {
        int a = graph.fe[j];
        int b = graph.e[j];
        int c = graph.w[j];
        if (dist[a] + c == dist[b]) {
          res[j] = (res[j] + f[a] * g[b] % mod) % mod;
        }

      }
    }
    for (long r : res) {
      out.println(r);
    }

  }

  private void dfs(Graph graph, int u, long[] dist) {
    if (g[u] != 0) {
      return;
    }
    g[u] = 1;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (dist[u] + graph.w[i] == dist[j]) {
        dfs(graph, j, dist);
        g[u] = (g[u] + g[j]) % mod;
      }
    }
  }

  public long[] dijkstra(Graph graph, int s) {
    long[] dist = new long[graph.N];
    boolean[] vis = new boolean[graph.N];

    Arrays.fill(dist, inf);
    dist[s] = 0;
    f[s] = 1;
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
          f[j] = f[u];
          priorityQueue.add(new long[]{dist[j], j, i});
        } else if (dist[j] == d + graph.w[i]) {
          f[j] = (f[j] + f[u]) % mod;
        }
      }
    }
    return dist;
  }
}
