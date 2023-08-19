package leetcode.b111;

import java.util.List;

/**
 * @author hum
 */
public class C1 {

  public int countPairs(List<Integer> nums, int target) {
    int res = 0;
    int n = nums.size();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums.get(i) + nums.get(j) < target) {
          res++;
        }
      }
    }
    return res;
  }
}
