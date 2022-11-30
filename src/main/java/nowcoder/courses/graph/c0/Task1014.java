package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Task1014 {
  int d, p, c, f, s;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    d = in.nextInt();
    p = in.nextInt();
    c = in.nextInt();
    f = in.nextInt();
    s = in.nextInt();
    Graph graph = new Graph(c, p + f, true);
    for (int i = 0; i < p; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      graph.add(a, b, 0);
    }
    for (int i = 0; i < f; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int w = in.nextInt();
      graph.add(a, b, w);
    }
    out.println(spfa(graph, s));

  }

  int spfa(Graph graph, int s) {
    int[] dist = new int[graph.N];
    boolean[] vis = new boolean[graph.N];
    int[] cnt = new int[graph.N];
    dist[s] = d;
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(s);

    vis[s] = true;
    while (!queue.isEmpty()) {
      int t = queue.poll();
      vis[t] = false;
      for (int i = graph.h[t]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (dist[j] < dist[t] - graph.w[i] + d) {
          dist[j] = dist[t] - graph.w[i] + d;
          if (cnt[j] >= c) {
            return -1;
          }
          if (!vis[j]) {
            queue.add(j);
            vis[j] = true;
          }
        }
      }
    }

    int res = 0;
    for (int i = 1; i <= c; i++) {
      res = Math.max(res, dist[i]);
    }
    return res;
  }
}
