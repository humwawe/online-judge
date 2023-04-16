package leetcode.b102;

/**
 * @author hum
 */
public class C1 {
  public int[] findColumnWidth(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[] res = new int[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        res[j] = Math.max(res[j], String.valueOf(grid[i][j]).length());
      }
    }
    return res;
  }
}
