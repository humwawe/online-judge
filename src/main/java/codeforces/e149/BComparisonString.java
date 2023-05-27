package codeforces.e149;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BComparisonString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int len = 0;
    char last = '-';
    int res = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != last) {
        len = 1;
      } else {
        len++;
      }
      res = Math.max(res, len);
      last = s.charAt(i);
    }
    out.println(res + 1);
  }
}
