package leetcode.b107;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {
  public int minimizeConcatenatedLength(String[] words) {
    int n = words.length;
    int[][][] dp = new int[n][26][26];
    int inf = (int) 1e8;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 26; j++) {
        Arrays.fill(dp[i][j], inf);
      }

    }

    dp[0][words[0].charAt(0) - 'a'][words[0].charAt(words[0].length() - 1) - 'a'] = words[0].length();

    for (int i = 1; i < n; i++) {

      int c1 = words[i].charAt(0) - 'a';
      int c2 = words[i].charAt(words[i].length() - 1) - 'a';

      for (int j = 0; j < 26; j++) {
        for (int k = 0; k < 26; k++) {
          dp[i][j][c2] = Math.min(dp[i][j][c2], dp[i - 1][j][k] + words[i].length());
          dp[i][c1][k] = Math.min(dp[i][c1][k], dp[i - 1][j][k] + words[i].length());
          if (c1 == k) {
            dp[i][j][c2] = Math.min(dp[i][j][c2], dp[i - 1][j][k] + words[i].length() - 1);
          }
          if (c2 == j) {
            dp[i][c1][k] = Math.min(dp[i][c1][k], dp[i - 1][j][k] + words[i].length() - 1);
          }


        }
      }
    }
    int res = inf;
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        res = Math.min(res, dp[n - 1][i][j]);
      }
    }
    return res;
  }
}
