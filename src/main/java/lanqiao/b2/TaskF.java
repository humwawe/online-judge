package lanqiao.b2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.math.BigInteger;

public class TaskF {
  int mod = 998244353;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String l = in.nextString();
    String r = in.nextString();
    long x = new NumDp(r).getRes();
    l = new BigInteger(l).subtract(BigInteger.ONE).toString();
    long y = new NumDp(l).getRes();
    out.println((x - y + mod) % mod);
  }

  class NumDp {
    int[] num;
    Long[][][] memo;
    int len;
    int m;

    public NumDp(String x) {
      int len = x.length();
      num = new int[len];
      for (int i = 0; i < len; i++) {
        num[i] = x.charAt(i) - '0';
      }
      m = x.charAt(x.length() - 1) - '0';
      memo = new Long[len][len * 9][10];
    }

    public long getRes() {
      if (num.length < 1) {
        return 0;
      }
      return dfs(0, 0, 0, true, true);
    }

    // dfs(0, 0, true, true);
    long dfs(int i, int cur, int last, boolean limit, boolean lead) {
      // 算到num的最后一位
      if (i == num.length) {
        if (last == 0) {
          return 0;
        }
        if (cur % last == 0) {
          return 1;
        }
        return 0;
      }
      if (!limit && !lead && memo[i][cur][last] != null) {
        return memo[i][cur][last];
      }

      long res = 0;
      // 可以跳过当前数位
      if (lead) {
        res = dfs(i + 1, cur, last, false, true);
      }

      int up = limit ? num[i] : 9;
      // 根据前导0判断是否能取到0
      int low = lead ? 1 : 0;

      for (int j = low; j <= up; j++) {
        res += dfs(i + 1, cur + j, j, limit && j == up, false);
        res %= mod;
      }
      if (!limit && !lead) {
        memo[i][cur][last] = res;
      }
      return res;
    }
  }
}
