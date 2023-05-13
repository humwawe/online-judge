package codeforces.e148;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ANewPalindrome {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    char last = s.charAt(0);
    int len = s.length() / 2;
    for (int i = 1; i < len; i++) {
      if (s.charAt(i) != last) {
        out.println("YES");
        return;
      }
    }
    out.println("NO");
  }
}
