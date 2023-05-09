package codeforces.c872;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ALuoTianyiAndThePalindromeString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }
    if (cnt[s.charAt(0) - 'a'] == s.length()) {
      out.println(-1);
      return;
    }
    out.println(s.length() - 1);
  }
}
