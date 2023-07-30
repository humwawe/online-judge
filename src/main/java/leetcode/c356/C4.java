package leetcode.c356;

import java.math.BigInteger;

/**
 * @author hum
 */
public class C4 {
  public int countSteppingNumbers(String low, String high) {
    BigInteger subtract = new BigInteger(low).subtract(BigInteger.ONE);
    NumDp(high);
    long res1 = getRes();
    NumDp(subtract.toString());
    long res2 = getRes();
    return (int) ((res1 - res2 + mod) % mod);
  }

  int mod = (int) (1e9 + 7);
  int[] num;
  Long[][] memo;
  int len;

  public void NumDp(String x) {
    len = x.length();
    num = new int[len];
    for (int i = 0; i < len; i++) {
      num[i] = x.charAt(i) - '0';
    }
    memo = new Long[len][11];
  }

  public long getRes() {
    return dfs(0, 10, true, true);
  }

  long dfs(int i, int last, boolean limit, boolean lead) {
    if (i == num.length) {
      return lead ? 0 : 1;
    }
    if (!limit && !lead && memo[i][last] != null) {
      return memo[i][last];
    }

    long res = 0;
    if (lead) {
      res = dfs(i + 1, last, false, true);
    }

    int up = limit ? num[i] : 9;
    int low = lead ? 1 : 0;

    for (int j = low; j <= up; j++) {
      if (last == 10 || Math.abs(j - last) == 1) {
        res += dfs(i + 1, j, limit && j == up, false);
        res %= mod;
      }
    }
    if (!limit && !lead) {
      memo[i][last] = res;
    }
    return res;
  }
}
