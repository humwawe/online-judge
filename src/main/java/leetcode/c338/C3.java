package leetcode.c338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class C3 {

  public List<Long> minOperations(int[] nums, int[] queries) {
    Arrays.sort(nums);
    int n = nums.length;
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
    List<Long> res = new ArrayList<>();
    for (long query : queries) {
      long t = 0;
      int l = 0;
      int r = n - 1;
      while (l < r) {
        int mid = l + r + 1 >> 1;
        if (nums[mid] <= query) {
          l = mid;
        } else {
          r = mid - 1;
        }
      }
      if (nums[l] <= query) {
        t += query * (l + 1) - sum[l + 1];
      }


      l = 0;
      r = n - 1;
      while (l < r) {
        int mid = l + r >> 1;
        if (nums[mid] >= query) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      if (nums[l] >= query) {
        t += sum[n] - sum[l] - query * (n - l);
      }
      res.add(t);
    }
    return res;
  }
}
