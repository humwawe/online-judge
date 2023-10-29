package leetcode.b116;

import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class C3 {
  public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    int n = nums.size();
    int inf = (int) -1e9;
    int[][] dp = new int[n + 1][target + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dp[i], -inf);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= target; j++) {
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
        if (j - nums.get(i - 1) >= 0) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - nums.get(i - 1)] + 1);
        }
      }
    }
    return dp[n][target] < inf / 2 ? -1 : dp[n][target];
  }
}
