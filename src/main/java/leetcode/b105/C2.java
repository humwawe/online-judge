package leetcode.b105;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class C2 {
  public int minExtraChar(String s, String[] dictionary) {
    int n = s.length();
    int[] dp = new int[n + 1];
    Set<String> set = new HashSet<>(Arrays.asList(dictionary));

    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] + 1;
      for (int j = 1; j <= i; j++) {
        if (set.contains(s.substring(j - 1, i))) {
          dp[i] = Math.min(dp[i], dp[j - 1]);
        }
      }
    }
    return dp[n];
  }
}
