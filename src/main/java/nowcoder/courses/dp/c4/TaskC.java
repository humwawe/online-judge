package nowcoder.courses.dp.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  int r;
  int[] a;
  int lim;
  long inf = (long) 1e15;
  long[][] dist;
  Long[][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    r = in.nextInt();
    a = new int[n];
    for (int i = 0; i < r; i++) {
      a[i] = in.nextInt() - 1;
    }

    dist = new long[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], inf);
      dist[i][i] = 0;
    }
    for (int i = 0; i < m; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      int z = in.nextInt();
      dist[x][y] = Math.min(dist[x][y], z);
      dist[y][x] = Math.min(dist[y][x], z);
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }
    lim = 1 << r;

    memo = new Long[r][lim];
    long res = dfs(-1, 0);
    out.println(res);

  }

  private long dfs(int u, int st) {
    if (st == lim - 1) {
      return 0;
    }
    if (u != -1 && memo[u][st] != null) {
      return memo[u][st];
    }
    long tmp = inf;
    for (int i = 0; i < r; i++) {
      if ((st >> i & 1) == 0) {
        long d = u == -1 ? 0 : dist[a[u]][a[i]];
        tmp = Math.min(tmp, d + dfs(i, st | (1 << i)));
      }
    }
    if (u != -1) {
      return memo[u][st] = tmp;
    }
    return tmp;

  }
}
