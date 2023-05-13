package leetcode.b104;

/**
 * @author hum
 */
public class C3 {

  public long maximumOr(int[] nums, int k) {
    int[] cnt = new int[64];
    int n = nums.length;
    for (int num : nums) {
      for (int i = 0; i < 32; i++) {
        if ((num >> i & 1) == 1) {
          cnt[i]++;
        }
      }
    }
    long res = 0;
    for (int num : nums) {
      for (int i = 0; i < 32; i++) {
        if ((num >> i & 1) == 1) {
          cnt[i]--;
          cnt[i + k]++;
        }
      }
      long cur = 0;
      for (int i = 0; i < 60; i++) {
        if (cnt[i] >= 1) {
          cur |= (1L << i);
        }
      }
      res = Math.max(res, cur);
      for (int i = 0; i < 32; i++) {
        if ((num >> i & 1) == 1) {
          cnt[i]++;
          cnt[i + k]--;
        }
      }
    }
    return res;
  }
}
