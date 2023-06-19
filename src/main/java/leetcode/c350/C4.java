package leetcode.c350;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {

  public int paintWalls(int[] cost, int[] time) {
    int n = cost.length;
    int inf = (int) 1e9;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, inf);

    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = n; j >= 0; j--) {
        dp[j] = Math.min(dp[j], dp[Math.max(j - time[i - 1] - 1, 0)] + cost[i - 1]);
      }
    }

    return dp[n];
  }
}
