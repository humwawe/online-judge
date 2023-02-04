package acwing.contest.weekly.c87;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskC {
  Graph graph;
  int len = 0;
  int[] dis;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    graph = new Graph(n, m);
    dis = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      graph.add(a, b);
    }

    dp(1, 1);
    out.println(len);
  }

  void dp(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dp(j, u);
      len = Math.max(len, dis[u] + dis[j] + 1);
      dis[u] = Math.max(dis[u], dis[j] + 1);
    }

  }
}
