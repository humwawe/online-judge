package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Task1007 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int s = in.nextInt();
    int t = in.nextInt();
    Graph graph = new Graph(n, m);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    int[] dist = new int[n + 1];
    boolean[] vis = new boolean[n + 1];
    int inf = 0x3f3f3f3f;
    int res = -1;
    Arrays.fill(dist, inf);
    Arrays.fill(vis, false);
    dist[s] = 0;
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    priorityQueue.add(new int[]{0, s});
    while (!priorityQueue.isEmpty()) {
      int[] poll = priorityQueue.poll();
      int d = poll[0];
      int v = poll[1];
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = graph.h[v]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (dist[j] > d + graph.w[i]) {
          dist[j] = d + graph.w[i];
          priorityQueue.add(new int[]{dist[j], j});
        }
      }
    }
    if (dist[t] != inf) {
      out.println(dist[t]);
    } else {
      out.println(-1);
    }
  }

}
