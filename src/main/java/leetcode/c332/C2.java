package leetcode.c332;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {


  public long countFairPairs(int[] nums, int lower, int upper) {
    int n = nums.length;
    Arrays.sort(nums);
    long res = 0;
    for (int i = 0; i < n - 1; i++) {
      int x = nums[i];
      if (x + nums[i + 1] > upper) {
        continue;
      }
      if (x + nums[n - 1] < lower) {
        continue;
      }
      int l = i + 1;
      int r = n - 1;
      int t = lower - x;
      while (l < r) {
        int mid = l + r >> 1;
        if (nums[mid] >= t) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      int ll = l;

      l = i + 1;
      r = n - 1;
      t = upper - x;
      while (l < r) {
        int mid = l + r + 1 >> 1;
        if (nums[mid] <= t) {
          l = mid;
        } else {
          r = mid - 1;
        }
      }
      res += l - ll + 1;
    }
    return res;
  }
}
