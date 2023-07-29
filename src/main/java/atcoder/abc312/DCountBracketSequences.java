package atcoder.abc312;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DCountBracketSequences {
  String s;
  int mod = 998244353;
  Long[][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = in.nextString();
    memo = new Long[s.length() + 5][s.length() + 5];
    out.println(dfs(0, 0));

  }

  private long dfs(int i, int cnt) {
    if (cnt < 0) {
      return 0;
    }
    if (i == s.length()) {
      if (cnt == 0) {
        return 1;
      } else {
        return 0;
      }
    }
    if (memo[i][cnt] != null) {
      return memo[i][cnt];
    }
    long res = 0;
    if (s.charAt(i) == '(') {
      res = (res + dfs(i + 1, cnt + 1)) % mod;
    } else if (s.charAt(i) == ')') {
      res = (res + dfs(i + 1, cnt - 1)) % mod;
    } else {
      res = (res + dfs(i + 1, cnt + 1)) % mod;
      res = (res + dfs(i + 1, cnt - 1)) % mod;
    }
    return memo[i][cnt] = res;
  }
}
