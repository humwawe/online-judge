package codeforces.c789;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class B1TokitsukazeAndGood01StringEasyVersion {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    int last = 0;
    int res = 0;
    for (int i = 0; i < n; ) {
      int j = i;
      while (j + 1 < n && s.charAt(i) == s.charAt(j + 1)) {
        j++;
      }
      int len = j - i + 1;
      if ((len + last) % 2 == 1) {
        res++;
        last = 1;
      } else {
        last = 0;
      }
      i = j + 1;
    }
    out.println(res);
  }
}
