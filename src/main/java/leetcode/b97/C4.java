package leetcode.b97;

/**
 * @author hum
 */
public class C4 {
  public boolean isPossibleToCutPath(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    long[][] fs = new long[n][m];
    int mod = (int) (1e9 + 7);
    fs[0][0] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          if (i - 1 >= 0) {
            fs[i][j] += fs[i - 1][j];
          }
          if (j - 1 >= 0) {
            fs[i][j] += fs[i][j - 1];
          }
          fs[i][j] %= mod;
        }
      }
    }

    long[][] ft = new long[n][m];
    ft[n - 1][m - 1] = 1;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (grid[i][j] == 1) {
          if (j + 1 < m) {
            ft[i][j] += ft[i][j + 1];
          }
          if (i + 1 < n) {
            ft[i][j] += ft[i + 1][j];
          }
          ft[i][j] %= mod;
        }
      }
    }

    if (fs[n - 1][m - 1] == 0) {
      return true;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 && j == 0) {
          continue;
        }
        if (i == n - 1 && j == m - 1) {
          continue;
        }
        if (grid[i][j] == 1) {
          if (fs[i][j] * ft[i][j] % mod == fs[n - 1][m - 1]) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
