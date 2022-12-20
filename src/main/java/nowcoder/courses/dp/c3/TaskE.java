package nowcoder.courses.dp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskE {
  Graph graph;
  int n;
  int q;
  int[][] dp;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    q = in.nextInt();
    graph = new Graph(n + 1, n - 1);
    dp = new int[n + 1][q + 1];
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      graph.add(a, b, c);
    }

    dfs(1, 1);
    out.println(dp[1][q]);
  }

  private void dfs(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);

      for (int k = q; k > -1; k--) {
        for (int l = 0; l < k; l++) {
          dp[u][k] = Math.max(dp[u][k], dp[u][k - l - 1] + dp[j][l] + graph.w[i]);
        }
      }
    }
  }
}
