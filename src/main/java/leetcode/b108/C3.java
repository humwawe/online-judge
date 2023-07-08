package leetcode.b108;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {

  public int minimumBeautifulSubstrings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    int inf = (int) 1e8;
    Arrays.fill(dp, inf);
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        String substring = s.substring(j - 1, i);
        if (check(substring)) {
          dp[i] = Math.min(dp[i], dp[j - 1] + 1);
        }
      }
    }
    if (dp[n] == inf) {
      return -1;
    }
    return dp[n];
  }

  private boolean check(String substring) {
    if (substring.charAt(0) == '0') {
      return false;
    }

    long t = Long.parseLong(substring, 2);
    while (t % 5 == 0) {
      t /= 5;
    }
    return t == 1;
  }
}
