package leetcode.c368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class C4 {
  public static void main(String[] args) {
    C4 c4 = new C4();
    System.out.println(c4.minimumChanges("acba", 2));

  }

  public int minimumChanges(String s, int k) {
    int n = s.length();
    List<Integer>[] lists = new List[n + 1];
    Arrays.setAll(lists, e -> new ArrayList<>());
    for (int i = 1; i <= n; i++) {
      for (int j = i + i; j <= n; j += i) {
        lists[j].add(i);
      }
    }
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        dist[i][j] = helper(s, i, j, lists[j - i + 1]);
      }
    }
    int inf = (int) 1e8;
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dp[i], inf);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int l = 1; l <= k; l++) {
        for (int j = 1; j < i; j++) {
          dp[i][l] = Math.min(dp[i][l], dp[j - 1][l - 1] + dist[j - 1][i - 1]);
        }
      }
    }
    return dp[n][k];

  }

  private int helper(String s, int i, int j, List<Integer> list) {
    int res = s.length();
    int n = j - i + 1;
    for (Integer len : list) {
      int k = n / len;
      int cnt = 0;
      for (int l = 0; l < k / 2 * len; l++) {
        int cur = k - l / len - 1;
        int idx = cur * len + l % len;
        if (s.charAt(i + l) != s.charAt(i + idx)) {
          cnt++;
        }
      }
      res = Math.min(res, cnt);
    }
    return res;
  }
}
