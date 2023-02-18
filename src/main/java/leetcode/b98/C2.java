package leetcode.b98;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int minimizeSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int min = Math.min(nums[n - 1] - nums[2], nums[n - 3] - nums[0]);
    min = Math.min(min, nums[n - 2] - nums[1]);
    return min;
  }
}
