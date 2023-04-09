package leetcode.c340;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {
  public int minimizeMax(int[] nums, int p) {
    Arrays.sort(nums);
    int l = 0;
    int r = (int) 1e9;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(nums, mid, p)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  private boolean check(int[] nums, int mid, int p) {

    int cnt = 0;

    for (int i = 0; i < nums.length - 1; ) {
      if (nums[i + 1] - nums[i] <= mid) {
        cnt++;
        i += 2;
      } else {
        i++;
      }
    }
    return cnt >= p;
  }
}
