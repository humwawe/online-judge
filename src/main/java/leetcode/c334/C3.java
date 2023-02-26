package leetcode.c334;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {

  public int maxNumOfMarkedIndices(int[] nums) {
    Arrays.sort(nums);
    rev(nums);
    int n = nums.length;
    int l = 0;
    int r = n / 2;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(nums, mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l * 2;
  }

  private boolean check(int[] nums, int mid) {
    int n = nums.length;
    for (int i = 0; i < mid; i++) {
      int x = nums[n - 1 - i];
      if (x * 2 > nums[mid - 1 - i]) {
        return false;
      }
    }
    return true;
  }

  private void rev(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      int t = nums[i];
      nums[i] = nums[j];
      nums[j] = t;
      i++;
      j--;
    }
  }
}
