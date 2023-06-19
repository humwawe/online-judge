package leetcode.c350;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int findValueOfPartition(int[] nums) {
    Arrays.sort(nums);
    int res = (int) (1e9 + 5);
    for (int i = 0; i < nums.length - 1; i++) {
      res = Math.min(res, nums[i + 1] - nums[i]);
    }
    return res;
  }
}
