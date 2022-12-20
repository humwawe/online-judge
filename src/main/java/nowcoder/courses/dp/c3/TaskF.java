package nowcoder.courses.dp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskF {
  int n;
  int[] a;
  Graph graph;
  long[] v;
  long ans = (long) -1e12;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    v = new long[n + 1];
    graph = new Graph(n + 1, n - 1);
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      graph.add(a, b);
    }
    dfs(1, 1);
    out.println(ans);
  }

  private void dfs(int u, int p) {
    v[u] = a[u];
    long tmp = 0;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      v[u] = Math.max(v[u], a[u] + v[j]);
      ans = Math.max(ans, tmp + a[u] + v[j]);
      tmp = Math.max(tmp, v[j]);
    }

    ans = Math.max(ans, v[u]);
  }
}
