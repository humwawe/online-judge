package leetcode.c341;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int maxDivScore(int[] nums, int[] divisors) {
    Arrays.sort(divisors);
    int cur = -1;
    int res = 0;
    for (int divisor : divisors) {
      int cnt = 0;
      for (int num : nums) {
        if (num % divisor == 0) {
          cnt++;
        }
      }
      if (cnt > cur) {
        cur = cnt;
        res = divisor;
      }
    }
    return res;
  }
}
