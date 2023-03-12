package leetcode.c336;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int maxScore(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    long sum = 0;
    int res = 0;
    for (int i = n - 1; i >= 0; i--) {
      sum += nums[i];
      if (sum > 0) {
        res++;
      }
    }
    return res;
  }
}
