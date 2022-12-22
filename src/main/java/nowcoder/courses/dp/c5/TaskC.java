package nowcoder.courses.dp.c5;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  int[] lim = new int[10];
  int mod = 20020219;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long a = in.nextLong();
    long b = in.nextLong();
    int q = in.nextInt();
    Arrays.fill(lim, 100);
    for (int i = 0; i < q; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      lim[x] = Math.min(lim[x], y);
    }
    NumDp numB = new NumDp(b);
    NumDp numA = new NumDp(a - 1);
    out.println(((numB.getRes() - numA.getRes()) % mod + mod + (a == 0 ? 1 : 0)) % mod);
  }


  class NumDp {
    int[] num;
    Long[][][] memo;
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
      memo = new Long[len][10][35];
    }

    public long getRes() {
      return dfs(0, 0, 0, true, true);
    }

    long dfs(int i, int last, int cnt, boolean limit, boolean lead) {
      if (i == num.length) {
        return 1;
      }
      if (!limit && !lead && memo[i][last][cnt] != null) {
        return memo[i][last][cnt];
      }

      long res = 0;
      if (lead) {
        res = dfs(i + 1, last, cnt, false, true);
      }

      int up = limit ? num[i] : 9;
      int low = lead ? 1 : 0;
      for (int j = low; j <= up; j++) {
        if (j == last) {
          if (cnt < lim[j]) {
            res += dfs(i + 1, j, cnt + 1, limit && j == up, false);
          }
        } else {
          res += dfs(i + 1, j, 1, limit && j == up, false);
        }
        res %= mod;
      }
      if (!limit && !lead) {
        memo[i][last][cnt] = res;
      }
      return res;
    }
  }
}
