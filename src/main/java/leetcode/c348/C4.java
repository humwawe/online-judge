package leetcode.c348;

import java.math.BigInteger;

/**
 * @author hum
 */
public class C4 {
  int min;
  int max;
  int mod = (int) (1e9 + 7);

  public int count(String num1, String num2, int minSum, int maxSum) {
    min = minSum;
    max = maxSum;
    BigInteger bigInteger = new BigInteger(num1);
    BigInteger subtract = bigInteger.subtract(new BigInteger("1"));
    String num = subtract.toString();
    return (numDp(num2) - numDp(String.valueOf(num)) + mod) % mod;
  }

  int[] num;
  Long[][] memo;

  public int numDp(String x) {
    num = new int[x.length()];
    for (int i = 0; i < x.length(); i++) {
      num[i] = x.charAt(i) - '0';
    }
    memo = new Long[25][500];
    return getRes();
  }

  public int getRes() {
    return (int) dfs(0, 0, true, true) % mod;
  }

  long dfs(int i, int st, boolean limit, boolean lead) {
    if (i == num.length) {
      if (st >= min && st <= max) {
        return lead ? 0 : 1;
      }
      return 0;
    }
    if (!limit && !lead && memo[i][st] != null) {
      return memo[i][st];
    }

    long res = 0;
    if (lead) {
      res = dfs(i + 1, st, false, true);
    }

    int up = limit ? num[i] : 9;
    int low = lead ? 1 : 0;

    for (int j = low; j <= up; j++) {
      res += dfs(i + 1, st + j, limit && j == up, false);
      res %= mod;
    }
    if (!limit && !lead) {
      memo[i][st] = res;
    }
    return res;
  }
}
