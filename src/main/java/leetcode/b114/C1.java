package leetcode.b114;

import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public int minOperations(List<Integer> nums, int k) {
    int n = nums.size();
    int res = n;
    for (int i = 0; i < n; i++) {
      long x = 0;
      for (int j = i; j < n; j++) {
        if (nums.get(j) <= k) {
          x |= 1L << nums.get(j) - 1;
        }

      }
      if (x == (1L << k) - 1) {
        res = Math.min(res, n - i);
      }
    }
    return res;
  }
}
