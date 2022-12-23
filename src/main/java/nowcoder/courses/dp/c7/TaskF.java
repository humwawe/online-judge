package nowcoder.courses.dp.c7;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskF {
  Graph graph;
  int[] size, dep;
  long[] ans;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    size = new int[n];
    dep = new int[n];
    ans = new long[n];
    graph = new Graph(n, n - 1);
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      graph.add(a, b);
    }

    dfs(0, 0);
    for (int i = 0; i < n; i++) {
      ans[0] += dep[i];
    }

    dfs2(0, 0);
    long res = (long) 1e15;
    for (int i = 0; i < n; i++) {
      res = Math.min(res, ans[i]);
    }
    out.println(res);
  }

  private void dfs(int u, int p) {
    size[u] = 1;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dep[j] = dep[u] + 1;
      dfs(j, u);
      size[u] += size[j];
    }
  }

  private void dfs2(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      ans[j] = ans[u] - size[j] + (n - size[j]);
      dfs2(j, u);
    }
  }
}
