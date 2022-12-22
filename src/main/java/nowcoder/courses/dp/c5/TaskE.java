package nowcoder.courses.dp.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskE {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextLong();

    NumDp numA = new NumDp(a);
    out.printf("Case %d: ", testNumber);
    out.println(numA.getRes());
  }


  class NumDp {
    int[] num;
    Long[][][][] memo;
    int len;

    public NumDp(long x) {
      int[] tmp = new int[35];
      len = 0;
      while (x > 0) {
        tmp[len++] = (int) (x % 10);
        x /= 10;
      }
      num = new int[len];
      for (int i = 0; i < len; i++) {
        num[i] = tmp[len - 1 - i];
      }
      memo = new Long[len][109][109][109];
    }

    public long getRes() {
      long res = 0;
      for (int i = 1; i < 109; i++) {
        res += dfs(0, 0, 0, i, true, true);
      }
      return res;
    }

    long dfs(int i, int mul, int sum, int mod, boolean limit, boolean lead) {
      if (i == num.length) {
        if (mul == 0 && sum == mod) {
          return 1;
        } else {
          return 0;
        }
      }
      if (!limit && !lead && memo[i][mul][sum][mod] != null) {
        return memo[i][mul][sum][mod];
      }

      long res = 0;
      if (lead) {
        res = dfs(i + 1, mul, sum, mod, false, true);
      }

      int up = limit ? num[i] : 9;
      int low = lead ? 1 : 0;
      for (int j = low; j <= up; j++) {
        res += dfs(i + 1, (mul * 10 + j) % mod, sum + j, mod, limit && j == up, false);
      }
      if (!limit && !lead) {
        memo[i][mul][sum][mod] = res;
      }
      return res;
    }
  }
}
