package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BPalindrome {

  Integer[][] memo;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
      if (cnt[i] >= 100) {
        out.println(String.valueOf((char) ('a' + i)).repeat(100));
        return;
      }
    }
    int len = s.length();
    memo = new Integer[len][len];
    dfs(s, 0, len - 1);
    StringBuilder sb = new StringBuilder();

    int i = 0;
    int j = len - 1;
    while (i < j) {
      if (s.charAt(i) == s.charAt(j)) {
        sb.append(s.charAt(i));
        i++;
        j--;
      } else if (memo[i + 1][j] != null && memo[i][j - 1] != null && memo[i + 1][j] >= memo[i][j - 1]) {
        i++;
      } else {
        j--;
      }
    }
    String o = sb.toString();
    String rev = sb.reverse().toString();
    StringBuilder res = new StringBuilder();
    res.append(o);
    if (i == j) {
      res.append(s.charAt(i));
    }
    res.append(rev);
    while (res.length() > 100) {
      res.deleteCharAt(res.length() / 2);
    }
    out.println(res.toString());

  }

  private int dfs(String s, int i, int j) {
    if (i > j) {
      return memo[i][j] = 0;
    }
    if (i == j) {
      return memo[i][j] = 1;
    }
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    if (s.charAt(i) == s.charAt(j)) {
      memo[i][j] = dfs(s, i + 1, j - 1) + 2;
      return memo[i][j];
    }
    return memo[i][j] = Math.max(dfs(s, i + 1, j), dfs(s, i, j - 1));
  }
}
