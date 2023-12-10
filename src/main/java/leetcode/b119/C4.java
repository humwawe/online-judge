package leetcode.b119;

/**
 * @author hum
 */
public class C4 {
  public int numberOfSets(int n, int maxDistance, int[][] roads) {
    int lim = 1 << n;
    int[][] dist = new int[n][n];
    int inf = (int) 1e8;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          dist[i][j] = 0;
        } else {
          dist[i][j] = inf;
        }
      }
    }
    for (int[] road : roads) {
      int x = road[0];
      int y = road[1];
      dist[x][y] = dist[y][x] = Math.min(dist[x][y], road[2]);
    }
    int res = 0;
    f:
    for (int st = 0; st < lim; st++) {
      int[][] d = new int[n][n];
      boolean[] vis = new boolean[n];
      for (int i = 0; i < n; i++) {
        if ((st >> i & 1) == 1) {
          vis[i] = true;
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i == j) {
            d[i][j] = 0;
          } else {
            d[i][j] = inf;
          }
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (vis[i] && vis[j]) {
            d[i][j] = dist[i][j];
          }
        }
      }


      for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            if (vis[i] && vis[j] && vis[k]) {
              d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
            }
          }
        }
      }


      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (vis[i] && vis[j]) {
            if (d[i][j] > maxDistance) {
              continue f;
            }
          }
        }
      }
      res++;
    }
    return res;
  }
}
