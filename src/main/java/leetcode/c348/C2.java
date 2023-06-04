package leetcode.c348;

/**
 * @author hum
 */
public class C2 {
  public int semiOrderedPermutation(int[] nums) {
    int n = nums.length;
    int min = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1) {
        min = i;
      }
      if (nums[i] == n) {
        max = i;
      }
    }

    if (min < max) {
      return min + (n - 1 - max);
    }

    return max + (n - 1 - (max + 1)) + (min - max);
  }
}
