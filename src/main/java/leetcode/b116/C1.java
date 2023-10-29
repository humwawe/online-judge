package leetcode.b116;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class C1 {
  public int sumCounts(List<Integer> nums) {
    int n = nums.size();
    int res = 0;
    for (int i = 0; i < n; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = i; j < n; j++) {
        set.add(nums.get(j));
        res += set.size() * set.size();
      }
    }
    return res;
  }
}
