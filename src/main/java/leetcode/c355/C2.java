package leetcode.c355;

/**
 * @author hum
 */
public class C2 {
  public long maxArrayValue(int[] nums) {
    int n = nums.length;
    long res = nums[n - 1];
    long cur = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i] <= cur) {
        cur += nums[i];
      } else {
        cur = nums[i];
      }
      res = Math.max(res, cur);
    }
    return res;
  }
}
