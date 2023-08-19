package leetcode.b111;

/**
 * @author hum
 */
public class C4 {
  int k;

  public int numberOfBeautifulIntegers(int low, int high, int k) {
    this.k = k;
    return numDp(high) - numDp(low - 1);
  }

  int[] num;
  Integer[][][] memo;
  int len;
  int base = 11;

  int numDp(int x) {
    int[] tmp = new int[15];
    len = 0;
    while (x > 0) {
      tmp[len++] = x % 10;
      x /= 10;
    }
    num = new int[len];
    for (int i = 0; i < len; i++) {
      num[i] = tmp[len - 1 - i];
    }
    memo = new Integer[len][22][22];
    return getRes();
  }

  public int getRes() {
    return dfs(0, 0, 0, true, true);
  }

  int dfs(int i, int diff, int dem, boolean limit, boolean lead) {
    if (i == num.length) {
      return diff == 0 && dem == 0 && !lead ? 1 : 0;
    }
    if (!limit && !lead && memo[i][diff + base][dem] != null) {
      return memo[i][diff + base][dem];
    }

    int res = 0;
    // 可以跳过当前数位
    if (lead) {
      res = dfs(i + 1, diff, dem, false, true);
    }

    int up = limit ? num[i] : 9;
    int low = lead ? 1 : 0;

    for (int j = low; j <= up; j++) {
      res += dfs(i + 1, diff - (j % 2 == 1 ? 1 : -1), (dem * 10 + j) % k, limit && j == up, false);

    }
    if (!limit && !lead) {
      memo[i][diff + base][dem] = res;
    }
    return res;
  }
}
