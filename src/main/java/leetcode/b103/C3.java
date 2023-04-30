package leetcode.b103;

/**
 * @author hum
 */
public class C3 {
  int ans;
  int[][] g;
  int n, m;

  public int findMaxFish(int[][] grid) {
    n = grid.length;
    m = grid[0].length;
    g = grid;
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] > 0) {
          ans = 0;
          dfs(i, j);
          res = Math.max(res, ans);
        }
      }
    }
    return res;
  }

  private void dfs(int i, int j) {
    if (i >= 0 && i < n && j >= 0 && j < m && g[i][j] > 0) {
      ans += g[i][j];
      g[i][j] = 0;
      dfs(i + 1, j);
      dfs(i - 1, j);
      dfs(i, j + 1);
      dfs(i, j - 1);
    }
  }
}
