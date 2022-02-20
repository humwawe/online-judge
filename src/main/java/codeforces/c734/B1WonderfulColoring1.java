package codeforces.c734;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class B1WonderfulColoring1 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int len = s.length();
    int[] cnt = new int[26];
    for (int i = 0; i < len; i++) {
      int t = s.charAt(i) - 'a';
      cnt[t]++;
    }
    int tmp1 = 0;
    int tmp2 = 0;
    for (int i = 0; i < 26; i++) {
      if (cnt[i] >= 2) {
        tmp1++;
      } else if (cnt[i] == 1) {
        tmp2++;
      }
    }
    out.println(tmp1 + tmp2 / 2);
  }
}
