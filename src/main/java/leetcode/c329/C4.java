package leetcode.c329;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  public int minCost(int[] nums, int k) {
    int n = nums.length;
    int[][] cost = new int[n][n];
    for (int i = 0; i < n; i++) {
      int[] cnt = new int[n];
      int c = 0;
      for (int j = i; j < n; j++) {
        cnt[nums[j]]++;
        if (cnt[nums[j]] == 1) {
          c++;
        } else if (cnt[nums[j]] == 2) {
          c--;
        }
        cost[i][j] = j - i + 1 - c;
      }
    }

    int[] dp = new int[n + 1];
    int inf = (int) (1e9 + 1e5);
    Arrays.fill(dp, inf);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] = Math.min(dp[i], dp[j] + cost[j][i - 1] + k);
      }
    }
    return dp[n];
  }
}
