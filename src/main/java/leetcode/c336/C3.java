package leetcode.c336;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {

  public long beautifulSubarrays(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    map.put(sum, 1);
    long res = 0;
    for (int num : nums) {
      res += map.getOrDefault(num ^ sum, 0);
      sum ^= num;
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return res;
  }
}
