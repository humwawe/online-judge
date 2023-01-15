package leetcode.c328;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {
  public long countGood(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    long res = 0;
    int j = -1;
    for (int i = 0; i < n; i++) {
      while (j + 1 < n && sum + map.getOrDefault(nums[j + 1], 0) < k) {
        sum += map.getOrDefault(nums[j + 1], 0);
        map.put(nums[j + 1], map.getOrDefault(nums[j + 1], 0) + 1);
        j++;
      }
      if (j != n - 1) {
        res += n - 1 - j;
      }

      map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
      sum -= map.getOrDefault(nums[i], 0);
    }
    return res;
  }
}
