package nowcoder.courses.dp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskA {
  Graph graph;
  int[] cnt, size;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    cnt = new int[n + 1];
    size = new int[n + 1];
    graph = new Graph(n + 1, n - 1);
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      graph.add(a, b);
    }
    dfs(1, 1);
    int min = (int) 1e8;
    int x = 0;
    for (int i = 1; i <= n; i++) {
      if (cnt[i] < min) {
        x = i;
        min = cnt[i];
      }
    }
    out.println(x, min);
  }

  private void dfs(int u, int p) {
    size[u] = 1;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      size[u] += size[j];
      cnt[u] = Math.max(cnt[u], size[j]);
    }
    cnt[u] = Math.max(cnt[u], n - size[u]);
  }
}
