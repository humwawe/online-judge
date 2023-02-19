package leetcode.c333;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class C3 {

  public int squareFreeSubsets(int[] nums) {
    int mod = (int) (1e9 + 7);
    Arrays.sort(nums);
    int n = nums.length;
    List<Integer> list = new ArrayList<>();
    for (int i = 2; i <= 30; i++) {
      if (isP(i)) {
        list.add(i);
      }
    }

    int[] t = new int[31];
    f:
    for (int i = 2; i <= 30; i++) {
      for (int j = 0, listSize = list.size(); j < listSize; j++) {
        Integer p = list.get(j);
        if (i % p == 0) {
          if (i % (p * p) == 0) {
            t[i] = -1;
            continue f;
          }
          t[i] |= 1 << j;
        }
      }
    }


    int lim = 1 << list.size();

    int[][] dp = new int[n + 1][lim];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      int x = t[nums[i - 1]];
      for (int j = 0; j < lim; j++) {
        dp[i][j] = dp[i - 1][j];
      }
      if (x < 0) {
        continue;
      }

      for (int j = 0; j < lim; j++) {
        if ((x & j) == 0) {
          dp[i][x | j] += dp[i - 1][j];
          dp[i][x | j] %= mod;
        }
      }
    }
    int res = 0;
    for (int i = 0; i < lim; i++) {
      res = (res + dp[n][i]) % mod;
    }
    return (res - 1 + mod) % mod;
  }


  private boolean isP(int i) {
    for (int j = 2; j < i; j++) {
      if (i % j == 0) {
        return false;
      }
    }
    return true;
  }
}
