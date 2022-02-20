package codeforces.cgr116;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CMAXMEXCut {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s1 = in.nextString();
    String s2 = in.nextString();
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        res += 2;
      } else if (s1.charAt(i) == '0') {
        if (i + 1 < n && s1.charAt(i + 1) == '1' && s2.charAt(i + 1) == '1') {
          res += 2;
          i += 1;
        } else {
          res += 1;
        }
      } else if (s1.charAt(i) == '1') {
        if (i + 1 < n && s1.charAt(i + 1) == '0' && s2.charAt(i + 1) == '0') {
          res += 2;
          i += 1;
        }
      }
    }
    out.println(res);
  }
}
