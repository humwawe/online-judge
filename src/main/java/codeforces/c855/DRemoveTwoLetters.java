package codeforces.c855;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DRemoveTwoLetters {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int res = n - 1;
    for (int i = 2; i < n; i++) {
      if (s.charAt(i) == s.charAt(i - 2)) {
        res--;
      }
    }
    out.println(res);
  }
}
