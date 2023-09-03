package leetcode.c361;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {
  public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
    int n = nums.size();
    long res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (nums.get(i) % modulo == k) {
        sum++;
      }
      sum %= modulo;
      res += map.getOrDefault((sum - k + modulo) % modulo, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return res;
  }
}
