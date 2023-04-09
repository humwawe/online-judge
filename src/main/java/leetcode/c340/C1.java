package leetcode.c340;

/**
 * @author hum
 */
public class C1 {
  public int diagonalPrime(int[][] nums) {
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      int x = nums[i][i];
      if (helper(x)) {
        res = Math.max(res, x);
      }
      int y = nums[i][n - i - 1];
      if (helper(y)) {
        res = Math.max(res, y);
      }
    }
    return res;
  }

  private boolean helper(int x) {
    if (x < 2) {
      return false;
    }
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }
}
