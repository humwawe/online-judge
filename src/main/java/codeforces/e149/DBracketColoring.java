package codeforces.e149;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DBracketColoring {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        cnt++;
      } else {
        cnt--;
      }
    }
    if (cnt != 0) {
      out.println(-1);
      return;
    }

    if (helper(s) || helper(new StringBuilder(s).reverse().toString())) {
      out.println(1);
      out.println("1 ".repeat(n));
      return;
    }

    out.println(2);
    cnt = 0;
    int c = 1;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        cnt++;
      } else {
        cnt--;
      }
      if (cnt == -1) {
        c = 2;
      }
      if (cnt == 1) {
        c = 1;
      }
      out.print(c, "");
    }
    out.println();


  }

  private boolean helper(String s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        cnt++;
      } else {
        cnt--;
        if (cnt < 0) {
          return false;
        }
      }
    }
    return true;
  }
}
