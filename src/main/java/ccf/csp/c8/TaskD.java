package ccf.csp.c8;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskD {
  Graph graph;
  int n, m;
  int ans;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    graph = new Graph(n, m * 2);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      int c = in.nextInt();
      graph.add(a, b, c);
    }

    int[] dist = dij(0);
    int res = 0;

    for (int i = 1; i < n; i++) {
      int min = inf;
      for (int j = graph.h[i]; j != -1; j = graph.ne[j]) {
        int k = graph.e[j];
        if (dist[i] == dist[k] + graph.w[j]) {
          min = Math.min(min, graph.w[j]);
        }
      }
      res += min;
    }
    out.println(res);
  }

  int inf = (int) (1e8 + 5);

  private int[] dij(int u) {

    int[] dist = new int[n];
    boolean[] vis = new boolean[n];
    Arrays.fill(dist, inf);
    dist[u] = 0;
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
    queue.add(new int[]{dist[0], 0});
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int cur = poll[1];
      if (vis[cur]) {
        continue;
      }
      vis[cur] = true;
      int d = poll[0];
      for (int i = graph.h[cur]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (dist[j] > d + graph.w[i]) {
          dist[j] = d + graph.w[i];
          queue.add(new int[]{dist[j], j});
        }
      }
    }
    return dist;


  }
}
