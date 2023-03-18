package leetcode.b100;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int maximizeGreatness(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int j = 0;
    int res = 0;
    for (int i = 0; i < n; i++) {
      while (j < n && nums[j] <= nums[i]) {
        j++;
      }
      if (j != n) {
        res++;
        j++;
      }
    }

    return res;

  }
}
