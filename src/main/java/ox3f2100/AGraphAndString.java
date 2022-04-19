package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class AGraphAndString {
  int N = 505;
  int M = N * N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, m;
  int[] color = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    boolean[][] vis = new boolean[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      vis[a][b] = true;
      vis[b][a] = true;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (!vis[i][j]) {
          add(i, j);
          add(j, i);
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      if (color[i] != 0 || h[i] == -1) {
        continue;
      }
      if (!dfs(i, 1)) {
        out.println("No");
        return;
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (vis[i][j] && (color[i] ^ color[j]) == 3) {
          out.println("No");
          return;
        }
      }
    }

    out.println("Yes");
    for (int i = 1; i <= n; i++) {
      if (color[i] == 1) {
        out.print("a");
      } else if (color[i] == 2) {
        out.print("c");
      } else {
        out.print("b");
      }
    }
    out.println();

  }

  boolean dfs(int u, int c) {
    color[u] = c;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (color[j] == 0) {
        if (!dfs(j, 3 - c)) {
          return false;
        }
      } else if (color[j] == c) {
        return false;
      }
    }
    return true;
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }

}
