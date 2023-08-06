package leetcode.b110;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {
  public int minimumSeconds(List<Integer> nums) {
    int n = nums.size();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.computeIfAbsent(nums.get(i), t -> new ArrayList<>()).add(i);
    }
    int res = Integer.MAX_VALUE;
    for (List<Integer> list : map.values()) {
      int max = list.get(0) - list.get(list.size() - 1) + n;
      for (int i = 1; i < list.size(); i++) {
        max = Math.max(max, list.get(i) - list.get(i - 1));
      }
      res = Math.min(res, max / 2);
    }
    return res;
  }
}
