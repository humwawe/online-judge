package ccf.csp.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskD {
  Graph graph;
  int n, m;
  int[] dp;
  int ans;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    dp = new int[n + m + 1];
    graph = new Graph(n + m, 2 * (n + m));
    for (int i = 0; i < n - 1; i++) {
      int x = in.nextInt();
      graph.add(i + 2, x);
    }

    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      graph.add(x, n + i + 1);
    }

    dfs(1, 1);
    out.println(ans);
  }

  private void dfs(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      ans = Math.max(ans, dp[u] + dp[j] + 1);
      dp[u] = Math.max(dp[u], dp[j] + 1);
    }
  }
}
