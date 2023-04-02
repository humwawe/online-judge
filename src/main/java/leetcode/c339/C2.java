package leetcode.c339;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C2 {
  public List<List<Integer>> findMatrix(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<List<Integer>> lists = new ArrayList<>();
    for (Integer integer : map.keySet()) {
      for (int i = 0; i < map.get(integer); i++) {
        if (lists.size() <= i) {
          lists.add(new ArrayList<>());
        }
        lists.get(i).add(integer);
      }
    }
    return lists;

  }
}
