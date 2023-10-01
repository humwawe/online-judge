package leetcode.c365;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {
  public int minSizeSubarray(int[] nums, int target) {
    int n = nums.length;
    long[] sum = new long[n * 2 + 1];
    long all = 0;
    for (int i = 0; i < 2 * n; i++) {
      sum[i + 1] = nums[i % n] + sum[i];
      if (i < n) {
        all += nums[i];
      }
    }
    Map<Long, Integer> map = new HashMap<>();
    map.put(0L, 0);
    int inf = (int) 2e9;
    long res = inf;
    for (int i = 1; i <= n * 2; i++) {
      long x = ((sum[i] - target) % all + all) % all;
      if (map.containsKey(x)) {
        long k = (x - sum[i] + target) / all;
        res = Math.min(res, i - map.get(x) + k * n);
      }
      map.put(sum[i], i);
    }
    if (res == inf) {
      return -1;
    }
    return (int) res;
  }
}
