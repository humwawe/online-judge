package leetcode.b110;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class C4 {
  public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
    int n = nums1.size();
    Integer[] idx = new Integer[n];
    Arrays.setAll(idx, i -> i);
    Arrays.sort(idx, Comparator.comparingInt(nums2::get));

    int[] dp = new int[n + 1];

    for (int ii = 0; ii < n; ii++) {
      int i = idx[ii];
      for (int j = n; j >= 1; j--) {
        dp[j] = Math.max(dp[j], dp[j - 1] + nums1.get(i) + j * nums2.get(i));
      }
    }
    int sum1 = 0;
    for (Integer integer : nums1) {
      sum1 += integer;
    }
    int sum2 = 0;
    for (Integer integer : nums2) {
      sum2 += integer;
    }

    for (int i = 0; i <= n; i++) {
      if (sum1 + i * sum2 - dp[i] <= x) {
        return i;
      }
    }
    return -1;

  }
}
