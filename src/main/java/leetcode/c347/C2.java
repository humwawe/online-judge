package leetcode.c347;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class C2 {
  public int[][] differenceOfDistinctValues(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] res = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {

        Set<Integer> set1 = new HashSet<>();
        int x = i;
        int y = j;
        while (true) {
          x--;
          y--;
          if (x >= 0 && x < n && y >= 0 && y < m) {
            set1.add(grid[x][y]);
          } else {
            break;
          }
        }
        Set<Integer> set2 = new HashSet<>();
        x = i;
        y = j;
        while (true) {
          x++;
          y++;
          if (x >= 0 && x < n && y >= 0 && y < m) {
            set2.add(grid[x][y]);
          } else {
            break;
          }
        }
        res[i][j] = Math.abs(set1.size() - set2.size());
      }
    }
    return res;
  }
}
