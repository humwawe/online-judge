package leetcode.b105;

/**
 * @author hum
 */
public class C3 {
  public long maxStrength(int[] nums) {
    int n = nums.length;
    long res = Long.MIN_VALUE;
    for (int i = 1; i < 1 << n; i++) {
      long cur = 1;
      for (int j = 0; j < n; j++) {
        if ((i >> j & 1) == 1) {
          cur *= nums[j];
        }
      }
      res = Math.max(res, cur);
    }
    return res;

  }
}
