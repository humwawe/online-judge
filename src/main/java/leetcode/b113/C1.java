package leetcode.b113;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public int minimumRightShifts(List<Integer> nums) {
    int n = nums.size();
    for (int i = 0; i < n; i++) {
      if (check(nums, i)) {
        return i;
      }
    }
    return -1;

  }

  private boolean check(List<Integer> nums, int i) {
    List<Integer> tmp = new ArrayList<>();
    for (int j = 0; j < nums.size(); j++) {
      tmp.add(0);
    }
    for (int j = 0; j < nums.size(); j++) {
      tmp.set((i + j) % nums.size(), nums.get(j));
    }

    for (int j = 1; j < tmp.size(); j++) {
      if (tmp.get(j) < tmp.get(j - 1)) {
        return false;
      }
    }
    return true;
  }
}
