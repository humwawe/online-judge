package leetcode.c368;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int minimumSum(int[] nums) {
    int n = nums.length;
    int[] pre = new int[n];
    Arrays.fill(pre, -1);
    int min = nums[0];
    for (int i = 1; i < n; i++) {
      if (min < nums[i]) {
        pre[i] = min;
      }
      min = Math.min(min, nums[i]);
    }
    int[] suf = new int[n];
    Arrays.fill(suf, -1);
    min = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if (min < nums[i]) {
        suf[i] = min;
      }
      min = Math.min(min, nums[i]);
    }
    int inf = (int) 1e9;
    int res = inf;
    for (int i = 1; i < n - 1; i++) {
      if (pre[i] == -1 || suf[i] == -1) {
        continue;
      }
      res = Math.min(res, pre[i] + nums[i] + suf[i]);
    }
    return res == inf ? -1 : res;
  }
}
