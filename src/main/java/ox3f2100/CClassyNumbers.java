package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CClassyNumbers {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    memo = new Integer[N][N];
    long l = in.nextLong() - 1;
    long r = in.nextLong();
    String s = String.valueOf(r);
    num = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      num[i] = s.charAt(i) - '0';
    }

    long rr = dfs(0, 0, true, true);
    memo = new Integer[N][N];

    s = String.valueOf(l);
    num = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      num[i] = s.charAt(i) - '0';
    }

    long lr = dfs(0, 0, true, true);
    out.println(rr - lr);

  }

  int N = 20;
  int[] num;
  Integer[][] memo;

  // dfs(0, 0, true, true);
  int dfs(int i, int st, boolean limit, boolean lead) {
    if (st > 3) {
      return 0;
    }
    // 算到num的最后一位
    if (i == num.length) {
      // 考虑能否取 0
      return 1;
    }
    if (!limit && !lead && memo[i][st] != null) {
      return memo[i][st];
    }

    int res = 0;
    // 可以跳过当前数位
    if (lead) {
      res = dfs(i + 1, st, false, true);
    }

    int up = limit ? num[i] : 9;
    // 根据前导0判断是否能取到0
    int low = lead ? 1 : 0;

    for (int j = low; j <= up; j++) {
      res += dfs(i + 1, st + (j == 0 ? 0 : 1), limit && j == up, false);
    }
    if (!limit && !lead) {
      memo[i][st] = res;
    }
    return res;
  }
}
