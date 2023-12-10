package leetcode.b119;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public int removeAlmostEqualCharacters(String word) {
    int n = word.length();
    int[][] dp = new int[n][26];
    int inf = 105;
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], inf);
    }
    for (int i = 0; i < 26; i++) {
      dp[0][i] = 1;
    }
    dp[0][word.charAt(0) - 'a'] = 0;

    for (int i = 1; i < n; i++) {
      int c = word.charAt(i) - 'a';
      for (int j = 0; j < 26; j++) {
        for (int k = 0; k < 26; k++) {
          if (Math.abs(j - k) > 1) {
            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + (j == c ? 0 : 1));
          }
        }
      }
    }
    int res = 105;
    for (int i = 0; i < 26; i++) {
      res = Math.min(res, dp[n - 1][i]);
    }
    return res;
  }
}
