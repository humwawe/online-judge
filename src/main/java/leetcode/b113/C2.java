package leetcode.b113;

import java.util.List;

/**
 * @author hum
 */
public class C2 {
  public int minLengthAfterRemovals(List<Integer> nums) {
    int n = nums.size();
    int cnt = 1;
    int max = 1;
    for (int i = 1; i < n; i++) {
      if (nums.get(i).equals(nums.get(i - 1))) {
        cnt++;
      } else {
        max = Math.max(max, cnt);
        cnt = 1;
      }
    }
    max = Math.max(max, cnt);

    if (max <= n / 2) {
      return n % 2;
    }
    return 2 * max - n;

  }
}
