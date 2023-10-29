package leetcode.c369;

/**
 * @author hum
 */
public class C1 {
  public int findKOr(int[] nums, int k) {
    int res = 0;
    for (int i = 0; i < 31; i++) {
      int cnt = 0;
      for (int num : nums) {
        if (((num >> i) & 1) == 1) {
          cnt++;
        }
      }
      if (cnt >= k) {
        res |= 1 << i;
      }
    }
    return res;

  }
}
