package acwing.contest.weekly.c97;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

public class TaskC {
  Graph graph;
  int[] a;
  int m;
  int ans;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    m = in.nextInt();
    graph = new Graph(n, n - 1);
    a = in.nextInt(n);
    for (int i = 0; i < n - 1; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      graph.add(x, y);
    }

    dfs(0, 0, a[0], a[0] > m);
    out.println(ans);
  }

  private void dfs(int u, int p, int cnt, boolean f) {
    boolean leaf = true;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      int t = a[j] == 1 ? cnt + 1 : 0;
      dfs(j, u, t, f | (t > m));
      leaf = false;
    }
    if (leaf) {
      if (!f) {
        ans++;
      }
    }
  }
}
