package leetcode.c340;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C2 {
  public long[] distance(int[] nums) {
    int n = nums.length;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
    }
    long[] res = new long[n];
    for (List<Integer> value : map.values()) {
      int size = value.size();
      long[] sum = new long[size + 1];

      for (int i = 1; i <= size; i++) {
        sum[i] = sum[i - 1] + value.get(i - 1);
      }

      for (int i = 0; i < size; i++) {
        res[value.get(i)] = ((long) i * value.get(i) - sum[i]) + (sum[size] - sum[i] - (long) (size - i) * value.get(i));
      }
    }
    return res;
  }
}
