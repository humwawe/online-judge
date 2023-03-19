package leetcode.c337;

/**
 * @author hum
 */
public class C3 {
  public int beautifulSubsets(int[] nums, int k) {
    int n = nums.length;
    int lim = 1 << n;
    int res = 0;
    boolean[] vis = new boolean[1005];
    for (int i = 1; i < lim; i++) {
      boolean f = true;
      for (int j = 0; j < n; j++) {
        if ((i >> j & 1) == 1) {
          vis[nums[j]] = true;
          if (nums[j] - k >= 0 && vis[nums[j] - k]) {
            f = false;
          }
          if (nums[j] + k < 1005 && vis[nums[j] + k]) {
            f = false;
          }
        }
      }
      if (f) {
        res++;
      }

      for (int j = 0; j < n; j++) {
        if ((i >> j & 1) == 1) {
          vis[nums[j]] = false;
        }
      }
    }
    return res;
  }
}
