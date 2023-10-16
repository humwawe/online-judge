package leetcode.c367;

/**
 * @author hum
 */
public class C4 {
  public int[][] constructProductMatrix(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] pre = new int[n][m];
    int[][] suf = new int[n][m];
    int[] row = new int[n];
    int t = 1;
    int mod = 12345;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        pre[i][j] = t;
        t = t * (grid[i][j] % mod) % mod;
      }
    }
    t = 1;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        suf[i][j] = t;
        t = t * (grid[i][j] % mod) % mod;
      }
    }
    int[][] res = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        res[i][j] = pre[i][j] * suf[i][j] % mod;
      }
    }
    return res;
  }
}
