package codeforces.hssc;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BReverseString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    String t = in.nextString();
    int len = t.length();
    f:
    for (int i = 0; i < s.length(); i++) {
      f1:
      for (int l = 0; l <= len; l++) {
        int tmp1 = i;
        int tmp2 = 0;
        for (int j = 0; j < l; j++) {
          if (tmp1 >= s.length()) {
            continue f;
          }
          if (s.charAt(tmp1++) != t.charAt(tmp2++)) {
            continue f;
          }
        }
        tmp1 = i + l - 1;

        int r = len - l;
        for (int j = 0; j < r; j++) {
          if (--tmp1 < 0) {
            continue f1;
          }
          if (s.charAt(tmp1) != t.charAt(tmp2++)) {
            continue f1;
          }
        }
        out.println("YES");
        return;
      }
    }
    out.println("NO");
  }
}
