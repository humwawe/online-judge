package leetcode.c368;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {
  public int minGroupsForValidAssignment(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int min = n;
    for (Integer value : map.values()) {
      min = Math.min(min, value);
    }

    f:
    for (int i = min; i > 0; i--) {
      int res = 0;
      for (Integer value : map.values()) {
        int k = value / i;
        int r = value % i;
        if (r > k) {
          continue f;
        }

        res += (value + i) / (i + 1);

      }
      return res;
    }
    return 1;
  }
}
