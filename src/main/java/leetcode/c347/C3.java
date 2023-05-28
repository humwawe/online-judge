package leetcode.c347;

/**
 * @author hum
 */
public class C3 {

  public long minimumCost(String s) {

    long[][] pre = helper(s);
    long[][] suf = helper(new StringBuilder(s).reverse().toString());

    int n = s.length();

    long res = Math.min(pre[n - 1][0], pre[n - 1][1]);
    res = Math.min(res, suf[n - 1][0]);
    res = Math.min(res, suf[n - 1][1]);
    for (int i = 0; i < n - 1; i++) {
      res = Math.min(res, pre[i][0] + suf[n - i - 2][0]);
      res = Math.min(res, pre[i][1] + suf[n - i - 2][1]);
    }
    return res;
  }

  private long[][] helper(String s) {
    int n = s.length();
    long[][] dp = new long[n][2];
    if (s.charAt(0) == '0') {
      dp[0][0] = 0;
      dp[0][1] = 1;
    } else {
      dp[0][0] = 1;
      dp[0][1] = 0;
    }

    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == '0') {
        dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + i);
        dp[i][1] = dp[i - 1][0] + i + 1;
      } else {
        dp[i][0] = dp[i - 1][1] + i + 1;
        dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0] + i);
      }
    }
    return dp;
  }


}
