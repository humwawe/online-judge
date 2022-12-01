package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Task1036 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] h = in.nextInt(n);
    Graph graph = new Graph(n, m);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    int inf = (int) (1e9 + 5);
    boolean[] vis = new boolean[n];
    int[] dist = new int[n];
    Arrays.fill(dist, inf);
    dist[0] = 0;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
      int d = h[y[1]] - h[x[1]];
      if (d == 0) {
        return x[0] - y[0];
      }
      return d;
    });
    priorityQueue.add(new int[]{0, 0});
    long res = 0;
    int cnt = 0;
    while (!priorityQueue.isEmpty()) {
      int[] cur = priorityQueue.poll();
      int d = cur[0];
      int u = cur[1];
      if (vis[u]) {
        continue;
      }
      res += d;
      cnt++;
      vis[u] = true;

      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (h[u] >= h[j]) {
          if (dist[j] > graph.w[i]) {
            dist[j] = graph.w[i];
            priorityQueue.add(new int[]{dist[j], j});
          }
        }
      }
    }
    out.println(cnt, res);
  }
}
