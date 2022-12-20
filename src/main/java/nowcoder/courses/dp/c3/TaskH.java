package nowcoder.courses.dp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;

public class TaskH {
  int n, m;
  Graph graph;
  long[] v;
  int ans = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    v = new long[n + 1];

    graph = new Graph(n, n - 1);
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    int inf = (int) 1e9;
    Arrays.fill(v, inf);
    dfs(1, 1, inf);
    if (v[1] > m) {
      out.println(-1);
      return;
    }
    int l = 1;
    int r = m;

    while (l < r) {
      int mid = l + r >> 1;
      Arrays.fill(v, inf);
      dfs(1, 1, mid);
      if (v[1] <= m) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    out.println(l);

  }

  private void dfs(int u, int p, int lim) {
    boolean f = false;
    long tmp = 0;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u, lim);
      f = true;
      if (graph.w[i] <= lim) {
        tmp += Math.min(v[j], graph.w[i]);
      } else {
        tmp += v[j];
      }
    }
    if (f) {
      v[u] = Math.min(tmp, v[u]);
    }
  }
}
