package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BAlphabeticalStrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int len = s.length();
    out.println(helper(s, 0, len - 1) ? "YES" : "NO");
  }

  private boolean helper(String s, int i, int j) {
    if (i == j) {
      return s.charAt(i) == 'a';
    }
    char c = (char) ('a' + j - i);
    if (s.charAt(i) == c) {
      return helper(s, i + 1, j);
    } else if (s.charAt(j) == c) {
      return helper(s, i, j - 1);
    }
    return false;
  }
}
