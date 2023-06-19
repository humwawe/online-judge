package leetcode.c350;

import java.util.Arrays;

/**
 * @author hum
 */
public class C3 {
  int n;
  int mod = (int) (1e9 + 7);
  boolean[][] mat;
  Long[][][] memo;

  public int specialPerm(int[] nums) {
    n = nums.length;
    mat = new boolean[n + 1][n + 1];
    memo = new Long[n + 1][n + 1][1 << n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
          mat[i][j] = true;
        }
      }
    }
    Arrays.fill(mat[n], true);

    return (int) dfs(n, 0, 0);
  }

  private long dfs(int last, int i, int st) {
    if (i == n) {
      return 1;
    }
    if (memo[last][i][st] != null) {
      return memo[last][i][st];
    }
    long res = 0;
    for (int j = 0; j < n; j++) {
      if ((st >> j & 1) == 0 && mat[last][j]) {
        res = (res + dfs(j, i + 1, st | (1 << j))) % mod;
      }
    }
    return memo[last][i][st] = res;

  }
}
