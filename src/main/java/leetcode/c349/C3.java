package leetcode.c349;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {

  public long minCost(int[] nums, int x) {
    int n = nums.length;
    int[][] min = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(min[i], (int) (1e9 + 5));
    }
    for (int i = 0; i < n; i++) {
      min[i][i] = nums[i];
      for (int j = i + 1; j < n; j++) {
        min[i][j] = Math.min(min[i][j - 1], nums[j]);
      }
    }

    int[][] t = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= n - 1; j++) {
        int l = i;
        int r = (i + j) % n;
        if (l <= r) {
          t[i][j] = min[l][r];
        } else {
          t[i][j] = Math.min(min[0][r], min[l][n - 1]);
        }
      }
    }

    long res = (long) 1e15;
    for (int i = 0; i < n; i++) {
      long tmp = 0;
      for (int j = 0; j < n; j++) {
        tmp += t[j][i];
      }
      res = Math.min(res, tmp + (long) i * x);
    }
    return res;
  }
}
