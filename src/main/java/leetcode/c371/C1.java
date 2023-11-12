package leetcode.c371;

/**
 * @author hum
 */
public class C1 {
  public int maximumStrongPairXor(int[] nums) {
    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
          res = Math.max(res, nums[i] ^ nums[j]);
        }
      }
    }
    return res;
  }
}
