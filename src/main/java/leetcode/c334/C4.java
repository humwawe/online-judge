package leetcode.c334;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C4 {
  public int minimumTime(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    if (grid[0][1] > 1 && grid[1][0] > 1) {
      return -1;
    }
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
    priorityQueue.add(new int[]{0, 0, 0});
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] vis = new boolean[n][m];
    while (!priorityQueue.isEmpty()) {
      int[] poll = priorityQueue.poll();
      int t = poll[0];
      int x = poll[1];
      int y = poll[2];
      if (vis[x][y]) {
        continue;
      }
      vis[x][y] = true;
      if (x == n - 1 && y == m - 1) {
        return t;
      }
      for (int[] f : fs) {
        int nx = f[0] + x;
        int ny = f[1] + y;
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
          if (grid[nx][ny] <= t + 1) {
            priorityQueue.add(new int[]{t + 1, nx, ny});
          } else {
            priorityQueue.add(new int[]{t + (grid[nx][ny] - t) / 2 * 2 + 1, nx, ny});
          }
        }
      }
    }
    return -1;
  }
}
