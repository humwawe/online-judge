package leetcode.c357;

import java.util.List;

/**
 * @author hum
 */
public class C2 {
  public boolean canSplitArray(List<Integer> nums, int m) {
    int n = nums.size();
    if (n <= 2) {
      return true;
    }
    for (int i = 0; i < n - 1; i++) {
      if (nums.get(i) + nums.get(i + 1) >= m) {
        return true;
      }
    }
    return false;
  }
}
