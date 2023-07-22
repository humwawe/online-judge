package leetcode.b109;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  int lim;
  int x;
  int mod = (int) (1e9 + 7);
  int[][] memo;
  int[] p;

  public int numberOfWays(int n, int x) {
    lim = 1;
    while (pow(lim + 1, x) <= n) {
      lim++;
    }
    this.x = x;
    p = new int[lim];

    for (int i = 0; i < lim; i++) {
      p[i] = pow(i + 1, x);
    }
    memo = new int[n + 1][lim + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(memo[i], -1);
    }

    //    int[] dp = new int[n + 1];
    //
    //    dp[0] = 1;
    //
    //    for (int i = 0; i < lim; i++) {
    //      for (int j = n; j >= 0; j--) {
    //        if (j >= p[i]) {
    //          dp[j] = (dp[j] + dp[j - p[i]]) % mod;
    //        }
    //      }
    //    }
    //    return dp[n];
    return dfs(n, 0);


  }

  private int dfs(int n, int last) {
    if (n == 0) {
      return 1;
    }
    if (n <= last) {
      return 0;
    }
    if (memo[n][last] != -1) {
      return memo[n][last];
    }
    int res = 0;
    for (int i = last + 1; i <= lim; i++) {
      res = (res + dfs(n - p[i - 1], i)) % mod;
    }
    return memo[n][last] = res;
  }

  private int pow(int i, int x) {
    int res = 1;
    for (int j = 0; j < x; j++) {
      res *= i;
    }
    return res;
  }
}
