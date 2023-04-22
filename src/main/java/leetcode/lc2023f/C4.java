package leetcode.lc2023f;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class C4 {

  int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  int tx, ty, sx, sy;
  char[][] maz;
  int n;
  int inf = (int) 1e8;
  int[][] dist;

  public int challengeOfTheKeeper(String[] maze) {
    n = maze.length;
    maz = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        maz[i][j] = maze[i].charAt(j);
        if (maz[i][j] == 'T') {
          tx = i;
          ty = j;
        }
        if (maz[i][j] == 'S') {
          sx = i;
          sy = j;
        }
      }
    }

    dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], inf);
    }

    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{tx, ty});
    dist[tx][ty] = 0;
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      for (int[] f : fs) {
        int x = f[0] + poll[0];
        int y = f[1] + poll[1];
        if (x >= 0 && x < n && y >= 0 && y < n && dist[x][y] == inf && maz[x][y] != '#') {
          dist[x][y] = dist[poll[0]][poll[1]] + 1;
          queue.add(new int[]{x, y});
        }
      }
    }

    int l = 0;
    int r = 40005;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(mid)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l == 40005 ? -1 : l;
  }

  private boolean check(int mid) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{sx, sy});
    boolean[][] vis = new boolean[n][n];
    vis[sx][sy] = true;
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      for (int[] f : fs) {
        int x = f[0] + poll[0];
        int y = f[1] + poll[1];
        if (x == tx && y == ty) {
          return true;
        }
        if (x >= 0 && x < n && y >= 0 && y < n && !vis[x][y] && maz[x][y] != '#') {
          int nx = n - 1 - x;
          int ny = n - 1 - y;
          if (maz[nx][y] != '#' && dist[nx][y] > mid) {
            continue;
          }
          if (maz[x][ny] != '#' && dist[x][ny] > mid) {
            continue;
          }
          queue.add(new int[]{x, y});
          vis[x][y] = true;
        }
      }
    }
    return vis[tx][ty];
  }

}
