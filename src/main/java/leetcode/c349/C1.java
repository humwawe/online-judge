package leetcode.c349;

import java.util.Arrays;

/**
 * @author hum
 */
public class C1 {
  public int findNonMinOrMax(int[] nums) {
    if (nums.length <= 2) {
      return -1;
    }
    Arrays.sort(nums);
    return nums[1];
  }
}
