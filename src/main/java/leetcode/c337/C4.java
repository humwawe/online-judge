package leetcode.c337;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class C4 {

  public int findSmallestInteger(int[] nums, int value) {
    int n = nums.length;
    Set<Long> set = new HashSet<>();
    Map<Long, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      long x = nums[i] % value;
      if (x < 0) {
        x += value;
      }
      if (map.containsKey(x)) {
        set.add(x + (long) value * (map.get(x)));
        map.put(x, map.get(x) + 1);
      } else {
        set.add(x);
        map.put(x, 1);
      }
    }
    for (long i = 0; ; i++) {
      if (!set.contains(i)) {
        return (int) i;
      }
    }
  }
}
