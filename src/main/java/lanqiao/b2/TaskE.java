package lanqiao.b2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskE {
  Graph graph;
  int n;
  long ans;
  long[] d;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    d = new long[n];
    graph = new Graph(n, 2 * n);
    long sum = 0;
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      int c = in.nextInt();
      graph.add(a, b, c);
      sum += c;
    }

    dfs(0, 0);
    out.println(2 * sum - ans);
  }

  private void dfs(int u, int p) {
    long max = 0;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      ans = Math.max(ans, max + d[j] + graph.w[i]);
      max = Math.max(max, d[j] + graph.w[i]);
    }
    d[u] = max;
  }
}
