package leetcode.c333;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  public String findTheString(int[][] lcp) {
    int n = lcp.length;
    char[] res = new char[n];
    Arrays.fill(res, '#');
    char c = 'a';
    for (int i = 0; i < n; i++) {
      if (res[i] == '#') {
        if (c > 'z') {
          return "";
        }
        res[i] = c++;
      } else {
        continue;
      }
      for (int j = i + 1; j < n; j++) {
        if (lcp[i][j] > 0) {
          if (res[j] != '#') {
            return "";
          }
          res[j] = res[i];
        }
      }
    }
    String s = new String(res);

    int[][] dp = new int[n + 1][n + 1];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j + 1] + 1;
        } else {
          dp[i][j] = 0;
        }
        if (dp[i][j] != lcp[i][j]) {
          return "";
        }
      }
    }


    return new String(res);
  }

}
