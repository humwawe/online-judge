package leetcode.c333;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C1 {
  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] ints : nums1) {
      map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
    }
    for (int[] ints : nums2) {
      map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
    }
    int[][] res = new int[map.size()][2];
    int idx = 0;
    for (Integer integer : map.keySet()) {
      res[idx][0] = integer;
      res[idx++][1] = map.get(integer);
    }
    Arrays.sort(res, Comparator.comparingInt(x -> x[0]));
    return res;
  }
}
