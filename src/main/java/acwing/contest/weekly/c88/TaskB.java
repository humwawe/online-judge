package acwing.contest.weekly.c88;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  String s1, s2;
  boolean[][] vis;
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    s1 = in.nextString();
    s2 = in.nextString();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        vis = new boolean[n][m];
        dfs(i, j);
        for (int k = 0; k < n; k++) {
          for (int l = 0; l < m; l++) {
            if (!vis[k][l]) {
              out.println("NO");
              return;
            }
          }
        }
      }
    }
    out.println("YES");
  }

  private void dfs(int i, int j) {
    vis[i][j] = true;
    char c = s1.charAt(i);
    char s = s2.charAt(j);
    int nx = (s == '^' ? i - 1 : i + 1);
    int ny = j;
    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
      dfs(nx, ny);
    }
    nx = i;
    ny = (c == '>' ? j + 1 : j - 1);
    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
      dfs(nx, ny);
    }
  }
}
