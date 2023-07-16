package leetcode.c354;

import java.util.List;

/**
 * @author hum
 */
public class C3 {
  public int minimumIndex(List<Integer> nums) {
    int x = 0;
    int cnt = 0;
    for (int num : nums) {
      if (cnt == 0) {
        x = num;
        cnt++;
      } else if (x == num) {
        cnt++;
      } else {
        cnt--;
      }
    }
    cnt = 0;
    for (int num : nums) {
      if (num == x) {
        cnt++;
      }
    }
    int t = 0;

    for (int i = 0; i < nums.size(); i++) {
      if (nums.get(i) == x) {
        t++;
      }
      int l = i + 1;
      int r = nums.size() - l;
      if (t * 2 > l && (cnt - t) * 2 > r) {
        return i;
      }
    }
    return -1;

  }
}
