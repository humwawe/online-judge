package nowcoder.courses.dp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskB {
  int[][] dp;
  int n;
  int[] h;
  Graph graph;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    h = new int[n + 1];
    graph = new Graph(n + 1, n - 1, true);
    dp = new int[n + 1][2];
    for (int i = 1; i <= n; i++) {
      h[i] = in.nextInt();
    }
    boolean[] vis = new boolean[n + 1];
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      graph.add(b, a);
      vis[a] = true;
    }
    int root = 0;
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        root = i;
        break;
      }
    }

    dfs(root);
    out.println(Math.max(dp[root][0], dp[root][1]));
  }

  private void dfs(int u) {

    dp[u][1] = h[u];
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      dfs(j);
      dp[u][0] += Math.max(dp[j][0], dp[j][1]);
      dp[u][1] += dp[j][0];
    }
  }
}
