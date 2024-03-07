package luogu.problems;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class SalazarSlytherinsLocket {
  long[][][] memo = new long[11][60][1 << 10];

  {
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 60; j++) {
        Arrays.fill(memo[i][j], -1);
      }
    }
  }

  int[] num = new int[60];
  int len;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int b = in.nextInt();
    long l = in.nextLong();
    long r = in.nextLong();
    h(r, b);
    long res1 = dfs(len - 1, 0, true, true, b);
    h(l - 1, b);
    long res2 = dfs(len - 1, 0, true, true, b);
    out.println(res1 - res2);
  }

  private void h(long v, int b) {
    len = 0;
    while (v > 0) {
      num[len++] = (int) (v % b);
      v /= b;
    }

  }

  long dfs(int i, int st, boolean limit, boolean lead, int b) {
    if (i == -1) {
      return st == 0 ? 1 : 0;
    }
    if (!limit && !lead && memo[b][i][st] != -1) {
      return memo[b][i][st];
    }

    long res = 0;
    if (lead) {
      res = dfs(i - 1, st, false, true, b);
    }

    int up = limit ? num[i] : b - 1;
    int low = lead ? 1 : 0;

    for (int j = low; j <= up; j++) {
      res += dfs(i - 1, st ^ (1 << j), limit && j == up, false, b);
    }
    if (!limit && !lead) {
      memo[b][i][st] = res;
    }
    return res;
  }
}
