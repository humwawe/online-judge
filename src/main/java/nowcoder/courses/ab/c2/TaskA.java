package nowcoder.courses.ab.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;

import java.util.Arrays;

public class TaskA {
  Graph graph;
  int[] mex;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    mex = new int[n];
    Arrays.fill(mex, -1);
    graph = new Graph(n, n * n, true);
    for (int i = 0; i < n; i++) {
      int k = in.nextInt();
      for (int j = 0; j < k; j++) {
        int b = in.nextInt();
        graph.add(i, b);
      }
    }

    for (int i = 0; i < n; i++) {
      dfs(i);
    }
    while (true) {
      int m = in.nextInt();
      if (m == 0) {
        return;
      }
      int res = 0;
      for (int i = 0; i < m; i++) {
        int x = in.nextInt();
        res ^= mex[x];
      }

      if (res == 0) {
        out.println("LOSE");
      } else {
        out.println("WIN");
      }

    }


  }

  private void dfs(int u) {
    if (mex[u] != -1) {
      return;
    }
    boolean[] vis = new boolean[n];
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      dfs(j);
      vis[mex[j]] = true;
    }
    for (int i = 0; i <= n; i++) {
      if (!vis[i]) {
        mex[u] = i;
        return;
      }
    }
  }
}
