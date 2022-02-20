package acwing.contest.weekly.c10;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    long res = 1;
    String s = in.nextString();
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
      res = Math.max(res, cnt[i]);
    }
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        res = Math.max(res, helper(s, i, j));
      }
    }
    out.println(res);
  }

  private long helper(String s, int i, int j) {
    long res = 0;
    int t = 0;
    for (int k = 0; k < s.length(); k++) {
      if (s.charAt(k) - 'a' == j) {
        res += t;
      }
      if (s.charAt(k) - 'a' == i) {
        t++;
      }
    }
    return res;
  }
}
