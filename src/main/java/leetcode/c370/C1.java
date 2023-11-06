package leetcode.c370;

/**
 * @author hum
 */
public class C1 {
  public int findChampion(int[][] grid) {
    int n = grid.length;
    f:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (grid[i][j] == 0) {
          continue f;
        }
      }
      return i;
    }
    return -1;
  }
}
