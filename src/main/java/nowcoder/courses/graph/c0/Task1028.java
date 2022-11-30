package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Task1028 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();

    int inf = (int) 1e8;
    Graph graph = new Graph(n, m);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    int[] cost = in.nextInt(k);
    for (int i = 1; i < k; i++) {
      cost[i] += cost[i - 1];
    }
    int[][] dist = new int[n + 1][k + 1];
    boolean[][] vis = new boolean[n + 1][k + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dist[i], inf);
    }

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    priorityQueue.add(new int[]{0, 1, 0});
    while (!priorityQueue.isEmpty()) {
      int[] poll = priorityQueue.poll();
      int d = poll[0];
      int v = poll[1];
      int t = poll[2];
      if (t >= k || vis[v][t]) {
        continue;
      }
      vis[v][t] = true;
      for (int i = graph.h[v]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (dist[j][t + 1] > d + graph.w[i]) {
          dist[j][t + 1] = d + graph.w[i];
          priorityQueue.add(new int[]{dist[j][t + 1], j, t + 1});
        }
      }
    }

    int res = inf;
    for (int i = 1; i <= k; i++) {
      res = Math.min(res, dist[n][i] + cost[i - 1]);
    }
    if (res == inf) {
      out.println(-1);
    } else {
      out.println(res);
    }
  }
}
