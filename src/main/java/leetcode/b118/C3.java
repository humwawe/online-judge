package leetcode.b118;

/**
 * @author hum
 */
public class C3 {
  public int minimumCoins(int[] prices) {
    int n = prices.length;
    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] + prices[i - 1];
      for (int j = 1; j < i; j++) {
        if (i - j <= j) {
          dp[i] = Math.min(dp[i], dp[j - 1] + prices[j - 1]);
        }
      }
    }
    return dp[n];
  }
}
