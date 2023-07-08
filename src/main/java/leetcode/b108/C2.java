package leetcode.b108;

import java.util.*;

/**
 * @author hum
 */
public class C2 {
  public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int i = 0; i < moveFrom.length; i++) {
      if (set.remove(moveFrom[i])) {
        set.add(moveTo[i]);
      }
    }
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);
    return list;
  }
}
