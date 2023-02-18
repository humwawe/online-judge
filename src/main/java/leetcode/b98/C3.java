package leetcode.b98;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class C3 {

  public int minImpossibleOR(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int i = 0; i < 31; i++) {
      if (!set.contains(1 << i)) {
        return 1 << i;
      }
    }
    return -1;
  }

}
