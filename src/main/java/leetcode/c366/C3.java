package leetcode.c366;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C3 {
  public int minOperations(String s1, String s2, int x) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        list.add(i);
      }
    }

    int n = list.size();

    if (n % 2 == 1) {
      return -1;
    }

    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n + 1];

    dp[0] = x;
    dp[1] = Math.min(dp[0] + x, (list.get(1) - list.get(0)) * 2);

    for (int i = 2; i < n; i++) {
      dp[i] = Math.min(dp[i - 1] + x, dp[i - 2] + (list.get(i) - list.get(i - 1)) * 2);
    }

    return dp[n - 1] / 2;
  }

}
