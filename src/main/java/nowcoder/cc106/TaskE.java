package nowcoder.cc106;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class TaskE {
  int n;
  long base = (long) (2e5 + 5);
  Set<Long> set;
  int[] vis;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int m = in.nextInt();
    vis = new int[n + 1];
    set = new HashSet<>();
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      set.add(a * base + b);
      set.add(b * base + a);
    }


    for (int i = 1; i <= n; i++) {
      if (vis[i] != 0) {
        continue;
      }
      if (dfs(i, i, 1)) {
        out.println("YES");
        return;
      }
    }
    out.println("NO");

  }

  private boolean dfs(int u, int p, int d) {
    vis[u] = d;
    for (int i = 1; i <= n; i++) {
      if (i == p || i == u) {
        continue;
      }
      if (set.contains(i * base + u)) {
        continue;
      }
      if (vis[i] != 0) {
        if ((vis[u] - vis[i]) % 2 == 0) {
          return true;
        }
        continue;
      }
      if (dfs(i, u, d + 1)) {
        return true;
      }
    }

    return false;
  }
}
