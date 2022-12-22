package nowcoder.courses.dp.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextLong();
    long b = in.nextLong();
    if (a < 0 && b < 0) {
      return;
    }
    NumDp numB = new NumDp(b);
    NumDp numA = new NumDp(a - 1);
    out.println(numB.getRes() - numA.getRes() + (a == 0 ? 1 : 0));
  }


  class NumDp {
    int[] num;
    Long[][] memo;
    int len;

    public NumDp(long x) {
      int[] tmp = new int[15];
      len = 0;
      while (x > 0) {
        tmp[len++] = (int) (x % 10);
        x /= 10;
      }
      num = new int[len];
      for (int i = 0; i < len; i++) {
        num[i] = tmp[len - 1 - i];
      }
      memo = new Long[len][len];
    }

    public long getRes() {
      return dfs(0, 0, true, true);
    }

    long dfs(int i, int cnt, boolean limit, boolean lead) {
      if (i == num.length) {
        return lead ? 1 : cnt;
      }
      if (!limit && !lead && memo[i][cnt] != null) {
        return memo[i][cnt];
      }

      long res = 0;
      if (lead) {
        res = dfs(i + 1, cnt, false, true);
      }

      int up = limit ? num[i] : 9;
      int low = lead ? 1 : 0;
      for (int j = low; j <= up; j++) {
        res += dfs(i + 1, cnt + (j == 0 ? 1 : 0), limit && j == up, false);
      }
      if (!limit && !lead) {
        memo[i][cnt] = res;
      }
      return res;
    }
  }
}
