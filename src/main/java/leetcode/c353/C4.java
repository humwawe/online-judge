package leetcode.c353;

/**
 * @author hum
 */
public class C4 {

  public boolean checkArray(int[] nums, int k) {
    int n = nums.length;
    int[] diff = new int[n];
    diff[0] = nums[0];
    for (int i = 1; i < n; i++) {
      diff[i] = nums[i] - nums[i - 1];
    }
    int[] tmp = new int[n + 1];
    for (int i = 0; i < n - k + 1; i++) {
      int x = diff[i] - tmp[i];
      tmp[i] += x;
      tmp[i + k] -= x;
    }
    for (int i = n - k + 1; i < n; i++) {
      if (diff[i] != tmp[i]) {
        return false;
      }
    }
    return true;
  }
}
