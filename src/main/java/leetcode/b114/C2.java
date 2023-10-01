package leetcode.b114;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C2 {
  public int minOperations(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int res = 0;
    for (Integer value : map.values()) {
      if (value == 1) {
        return -1;
      }

      res += (value + 2) / 3;
    }
    return res;
  }
}
