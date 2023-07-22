package leetcode.b109;

/**
 * @author hum
 */
public class C3 {
  public long maxScore(int[] nums, int x) {
    int n = nums.length;
    long[] dp = new long[n];
    dp[0] = nums[0];
    long[] tmp = new long[2];
    tmp[nums[0] % 2] = nums[0];
    tmp[(nums[0] % 2) ^ 1] = (long) -1e17;
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(tmp[nums[i] % 2] + nums[i], tmp[(nums[i] % 2) ^ 1] - x + nums[i]);
      tmp[nums[i] % 2] = Math.max(tmp[nums[i] % 2], dp[i]);
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
