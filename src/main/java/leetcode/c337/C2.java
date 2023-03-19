package leetcode.c337;

/**
 * @author hum
 */

public class C2 {
  public boolean checkValidGrid(int[][] grid) {
    int n = grid.length;
    if (grid[0][0] != 0) {
      return false;
    }
    for (int i = 0; i < n * n - 1; i++) {
      int cur = i;
      int next = i + 1;
      int cx = -1;
      int cy = -1;
      int nx = -1;
      int ny = -1;
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (grid[j][k] == cur) {
            cx = j;
            cy = k;
          }
          if (grid[j][k] == next) {
            nx = j;
            ny = k;
          }
        }
      }
      if (!check(cx, cy, nx, ny)) {
        return false;
      }
    }
    return true;
  }

  private boolean check(int cx, int cy, int nx, int ny) {
    int[][] fs = new int[][]{{-1, 2}, {-1, -2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}, {-2, 1}, {-2, -1}};
    for (int[] f : fs) {
      if (nx == cx + f[0] && ny == cy + f[1]) {
        return true;
      }
    }
    return false;
  }
}
