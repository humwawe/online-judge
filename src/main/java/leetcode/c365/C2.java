package leetcode.c365;

/**
 * @author hum
 */
public class C2 {
  public long maximumTripletValue(int[] nums) {
    int n = nums.length;
    long res = 0;
    long[] dp = new long[n];
    long max = nums[0];
    for (int i = 1; i < n; i++) {
      dp[i] = max - nums[i];
      max = Math.max(max, nums[i]);
    }

    max = dp[1];
    for (int i = 2; i < n; i++) {
      res = Math.max(res, max * nums[i]);
      max = Math.max(max, dp[i]);
    }
    return res;
  }
}
