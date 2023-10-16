package leetcode.c366;

import java.util.List;

/**
 * @author hum
 */
public class C4 {
  public int maxSum(List<Integer> nums, int k) {
    int[] cnt = new int[31];
    for (Integer num : nums) {
      for (int j = 0; j < 31; j++) {
        if ((num >> j & 1) == 1) {
          cnt[j]++;
        }
      }
    }
    long res = 0;
    int mod = (int) (1e9 + 7);

    for (int i = 0; i < k; i++) {
      long cur = 0;
      for (int j = 0; j < 31; j++) {
        if (cnt[j] > 0) {
          cur |= 1 << j;
          cnt[j]--;
        }
      }
      res = (res + cur * cur) % mod;
    }
    return (int) res;
  }
}
