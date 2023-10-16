package leetcode.b115;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class C3 {
  public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
    boolean[][] dist = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        dist[i][j] = helper(words[i], words[j]);
      }
    }

    int[] dp = new int[n];
    int[] fa = new int[n];

    dp[0] = 1;
    fa[0] = -1;
    int max = 1;
    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      fa[i] = -1;
      for (int j = 0; j < i; j++) {
        if (dist[j][i] && groups[j] != groups[i] && dp[i] <= dp[j] + 1) {
          dp[i] = dp[j] + 1;
          fa[i] = j;
        }
      }
      max = Math.max(max, dp[i]);
    }
    int t = -1;
    for (int i = 0; i < n; i++) {
      if (dp[i] == max) {
        t = i;
        break;
      }
    }
    List<String> res = new ArrayList<>();
    res.add(words[t]);
    while (fa[t] != -1) {
      res.add(words[fa[t]]);
      t = fa[t];
    }
    Collections.reverse(res);
    return res;
  }

  private boolean helper(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        cnt++;
      }
    }
    return cnt == 1;
  }
}
