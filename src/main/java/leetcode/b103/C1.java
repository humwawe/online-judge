package leetcode.b103;

import java.util.Arrays;

/**
 * @author hum
 */
public class C1 {
  public int maximizeSum(int[] nums, int k) {
    Arrays.sort(nums);
    int max = nums[nums.length - 1];
    int res = 0;
    for (int i = 0; i < k; i++) {
      res += max;
      max++;
    }
    return res;
  }
}
