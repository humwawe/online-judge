package leetcode.c363;

import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class C2 {
  public int countWays(List<Integer> nums) {
    Collections.sort(nums);
    int n = nums.size();
    int res = 0;
    for (int i = 0; i < n - 1; i++) {
      int x = i + 1;
      if (x > nums.get(i) && nums.get(i + 1) > x) {
        res++;
      }
    }

    if (0 < nums.get(0)) {
      res++;
    }

    if (n > nums.get(n - 1)) {
      res++;
    }
    return res;
  }
}
