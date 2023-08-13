package leetcode.c345;

/**
 * @author hum
 */
public class C3 {
  int n, m;
  Integer[][] memo;
  int[][] fs = new int[][]{{-1, 1}, {0, 1}, {1, 1}};
  int[][] grid;

  public int maxMoves(int[][] grid) {
    n = grid.length;
    m = grid[0].length;
    this.grid = grid;
    memo = new Integer[n][m];
    int res = 0;
    for (int i = 0; i < n; i++) {
      int t = dfs(i, 0);
      res = Math.max(res, t);
    }
    return res;
  }

  private int dfs(int i, int j) {
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    int t = 0;
    for (int[] f : fs) {
      int x = i + f[0];
      int y = j + f[1];
      if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > grid[i][j]) {
        t = Math.max(t, dfs(x, y) + 1);
      }
    }
    return memo[i][j] = t;
  }
}
