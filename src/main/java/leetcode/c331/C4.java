package leetcode.c331;

import java.util.*;

/**
 * @author hum
 */
public class C4 {


  public long minCost(int[] basket1, int[] basket2) {
    int min = (int) (1e9 + 5);
    Map<Integer, Integer> sum = new HashMap<>();
    Map<Integer, Integer> map1 = new HashMap<>();
    for (int i : basket1) {
      min = Math.min(min, i);
      map1.put(i, map1.getOrDefault(i, 0) + 1);
      sum.put(i, sum.getOrDefault(i, 0) + 1);
    }
    Map<Integer, Integer> map2 = new HashMap<>();
    for (int i : basket2) {
      min = Math.min(min, i);
      map2.put(i, map2.getOrDefault(i, 0) + 1);
      sum.put(i, sum.getOrDefault(i, 0) + 1);
    }

    for (Integer value : sum.values()) {
      if (value % 2 != 0) {
        return -1;
      }
    }

    List<Integer> list = new ArrayList<>();

    int size = 0;
    for (Integer integer : sum.keySet()) {
      int v = sum.get(integer) / 2;
      int x = map1.getOrDefault(integer, 0);
      int d = Math.abs(v - x);
      for (int i = 0; i < d; i++) {
        list.add(integer);
      }
      if (v > x) {
        size += v - x;
      }

    }

    Collections.sort(list);

    long res = 0;
    min *= 2;
    for (int i = 0; i < size; i++) {
      res += list.get(i) > min ? min : list.get(i);
    }
    return res;
  }
}
