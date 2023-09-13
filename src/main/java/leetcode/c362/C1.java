package leetcode.c362;

import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public int numberOfPoints(List<List<Integer>> nums) {
    int res = 0;
    f:
    for (int i = 1; i <= 100; i++) {
      for (List<Integer> num : nums) {
        if (num.get(0) <= i && i <= num.get(1)) {
          res++;
          continue f;
        }
      }
    }
    return res;
  }
}
