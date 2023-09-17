package leetcode.b113;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C3 {
  int res = 0;

  public int countPairs(List<List<Integer>> coordinates, int k) {
    for (int i = 0; i <= k; i++) {
      int x = i;
      int y = k - i;
      helper(coordinates, x, y);
    }
    return res;
  }

  private void helper(List<List<Integer>> coordinates, int x, int y) {
    long base = (long) 1e7;
    Map<Long, Integer> map = new HashMap<>();

    for (List<Integer> coordinate : coordinates) {
      int i = coordinate.get(0);
      int j = coordinate.get(1);

      int ti = x ^ i;
      int tj = y ^ j;

      long need = base * ti + tj;

      res += map.getOrDefault(need, 0);
      long cur = base * i + j;
      map.put(cur, map.getOrDefault(cur, 0) + 1);
    }

  }
}
