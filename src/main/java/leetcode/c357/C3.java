package leetcode.c357;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class C3 {
  int n;
  int[][] dist;
  int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


  public int maximumSafenessFactor(List<List<Integer>> grid) {
    n = grid.size();
    dist = new int[n][n];

    if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
      return 0;
    }

    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], -1);
    }
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid.get(i).get(j) == 1) {
          queue.add(new int[]{i, j});
          dist[i][j] = 0;
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      for (int[] f : fs) {
        int nx = f[0] + poll[0];
        int ny = f[1] + poll[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] == -1) {
          dist[nx][ny] = dist[poll[0]][poll[1]] + 1;
          queue.add(new int[]{nx, ny});
        }
      }
    }

    int l = 0;
    int r = 2 * n;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }

  private boolean check(int mid) {
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][] vis = new boolean[n][n];
    queue.add(new int[]{0, 0});
    vis[0][0] = true;
    if (dist[0][0] < mid) {
      return false;
    }
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      for (int[] f : fs) {
        int nx = f[0] + poll[0];
        int ny = f[1] + poll[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny] && dist[nx][ny] >= mid) {
          queue.add(new int[]{nx, ny});
          vis[nx][ny] = true;
        }
      }
    }
    return vis[n - 1][n - 1];
  }
}
