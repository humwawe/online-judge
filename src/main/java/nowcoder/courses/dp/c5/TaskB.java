package nowcoder.courses.dp.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextLong();
    long b = in.nextLong();
    if (a == 0 && b == 0) {
      return;
    }
    NumDp numB = new NumDp(b);
    NumDp numA = new NumDp(a - 1);
    out.println(numB.getRes() - numA.getRes());
  }


  class NumDp {
    int[] num;
    Long[][][][] memo;
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
      memo = new Long[len][10][2][2];
    }

    public long getRes() {
      return dfs(0, 0, false, false, true, true);
    }

    long dfs(int i, int last, boolean e, boolean f, boolean limit, boolean lead) {
      if (i == num.length) {
        if (e | f) {
          return 1;
        } else {
          return 0;
        }
      }
      int x = e ? 1 : 0;
      int y = f ? 1 : 0;
      if (!limit && !lead && memo[i][last][x][y] != null) {
        return memo[i][last][x][y];
      }

      long res = 0;
      if (lead) {
        res = dfs(i + 1, last, e, f, false, true);
      }

      int up = limit ? num[i] : 9;
      int low = lead ? 1 : 0;
      for (int j = low; j <= up; j++) {
        res += dfs(i + 1, j, e | (last == 3 && j == 8), f | (j == 4), limit && j == up, false);
      }
      if (!limit && !lead) {
        memo[i][last][x][y] = res;
      }
      return res;
    }
  }
}
