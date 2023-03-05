package leetcode.c335;

/**
 * @author hum
 */
public class C4 {
  public int waysToReachTarget(int target, int[][] types) {
    int n = types.length;
    int[][] dp = new int[n + 1][target + 1];
    dp[0][0] = 1;
    int mod = (int) (1e9 + 7);
    for (int i = 1; i <= n; i++) {
      int c = types[i - 1][0];
      int m = types[i - 1][1];
      for (int j = 0; j <= target; j++) {

        for (int k = 0; k <= c; k++) {
          if (j >= k * m) {
            dp[i][j] = (dp[i][j] + dp[i - 1][j - k * m]) % mod;
          }
        }
      }
    }
    return dp[n][target];
  }
}
