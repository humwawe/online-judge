package leetcode.b108;

/**
 * @author hum
 */
public class C1 {
  public int alternatingSubarray(int[] nums) {
    int n = nums.length;
    int res = -1;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (check(nums, i, j)) {
          res = Math.max(res, j - i + 1);
        }
      }
    }
    return res;
  }

  private boolean check(int[] nums, int i, int j) {
    if (nums[i + 1] - nums[i] != 1) {
      return false;
    }
    int t = nums[i];
    for (int k = i; k <= j; k += 2) {
      if (nums[k] != t) {
        return false;
      }
    }
    t = nums[i + 1];
    for (int k = i + 1; k <= j; k += 2) {
      if (nums[k] != t) {
        return false;
      }
    }
    return true;
  }
}
