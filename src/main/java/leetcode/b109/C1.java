package leetcode.b109;

import java.util.Arrays;

/**
 * @author hum
 */
public class C1 {
  public boolean isGood(int[] nums) {
    int n = nums.length;
    int[] tmp = new int[n];
    for (int i = 0; i < n - 1; i++) {
      tmp[i] = i + 1;
    }
    tmp[n - 1] = n - 1;

    Arrays.sort(nums);

    for (int i = 0; i < n; i++) {
      if (tmp[i] != nums[i]) {
        return false;
      }
    }
    return true;
  }
}
