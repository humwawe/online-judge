package codeforces.c744;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ACasimirsStringSolitaire {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int cnt1 = 0;
    int cnt2 = 0;
    for (char c : s.toCharArray()) {
      if (c == 'B') {
        cnt1++;
      } else {
        cnt2++;
      }
    }
    if (cnt1 == cnt2) {
      out.println("YES");
    } else {
      out.println("NO");
    }
  }
}
