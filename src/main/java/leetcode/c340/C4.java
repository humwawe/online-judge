package leetcode.c340;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class C4 {

  public int minimumVisitedCells(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Queue<int[]> queue = new ArrayDeque<>();

    int[] row = new int[n];
    int[] col = new int[m];

    queue.add(new int[]{0, 0});
    int[][] dist = new int[n][m];
    int inf = (int) 1e8;
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], inf);
    }
    dist[0][0] = 1;
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int i = poll[0];
      int j = poll[1];
      for (int k = Math.max(row[i] + 1, j + 1); k <= Math.min(grid[i][j] + j, m - 1); k++) {
        if (dist[i][k] > dist[i][j] + 1) {
          dist[i][k] = dist[i][j] + 1;
          queue.add(new int[]{i, k});
        }
      }
      row[i] = Math.max(row[i], grid[i][j] + j);

      for (int k = Math.max(col[j] + 1, i + 1); k <= Math.min(grid[i][j] + i, n - 1); k++) {
        if (dist[k][j] > dist[i][j] + 1) {
          dist[k][j] = dist[i][j] + 1;
          queue.add(new int[]{k, j});
        }
      }
      col[j] = Math.max(col[j], grid[i][j] + i);
    }

    return dist[n - 1][m - 1] == inf ? -1 : dist[n - 1][m - 1];
  }
}
