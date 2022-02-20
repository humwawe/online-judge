package codeforces.c726;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class E1EraseAndExtendEasyVersion {
  int n, k;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    String s = in.nextString();
    StringBuilder stringBuilder = new StringBuilder();
    String res = "-1";
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) > s.charAt(0)) {
        break;
      }
      stringBuilder.append(s.charAt(i));
      res = getMin(res, stringBuilder);
    }
    out.println(res);
  }

  private String getMin(String res, StringBuilder stringBuilder) {
    StringBuilder ret = new StringBuilder();
    while (ret.length() < k) {
      ret.append(stringBuilder);
    }
    String substring = ret.substring(0, k);
    if (res.equals("-1")) {
      return substring;
    }
    if (res.compareTo(substring) > 0) {
      return substring;
    } else {
      return res;
    }
  }
}
