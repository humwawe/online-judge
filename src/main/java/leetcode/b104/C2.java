package leetcode.b104;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int matrixSum(int[][] nums) {
    int n = nums.length;
    int m = nums[0].length;
    for (int i = 0; i < n; i++) {
      Arrays.sort(nums[i]);
    }
    int res = 0;
    for (int j = 0; j < m; j++) {
      int max = 0;
      for (int i = 0; i < n; i++) {
        max = Math.max(max, nums[i][j]);
      }
      res += max;
    }
    return res;
  }
}
