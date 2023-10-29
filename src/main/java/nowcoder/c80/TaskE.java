package nowcoder.c80;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.Graph;
import util.MathMeth;

import java.util.Arrays;

public class TaskE {
  int n;
  int[] a, b, match;
  Graph graph;
  boolean[] vis;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    a = in.nextInt(n);
    b = in.nextInt(n);

    graph = new Graph(n * 2, n * n, true);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (MathMeth.gcd(a[i], b[j]) == 1) {
          graph.add(i, j + n);
        }
      }
    }
    int cnt = 0;
    match = new int[n];
    vis = new boolean[n];
    Arrays.fill(match, -1);
    for (int i = 0; i < n; i++) {
      Arrays.fill(vis, false);
      if (find(i)) {
        cnt++;
      }
    }

    if (cnt == n) {
      out.println("Bob");
    } else {
      out.println("Alice");
    }
  }

  private boolean find(int u) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i] - n;
      if (!vis[j]) {
        vis[j] = true;
        if (match[j] == -1 || find(match[j])) {
          match[j] = u;
          return true;
        }
      }
    }
    return false;
  }
}
