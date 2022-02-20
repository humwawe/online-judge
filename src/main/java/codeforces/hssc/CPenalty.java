package codeforces.hssc;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPenalty {
  int res;
  String s;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = in.nextString();
    res = 10;
    dfs(0, "");
    out.println(res);
  }

  private void dfs(int p, String tmp) {
    if (p == 10) {
      upd(tmp);
      return;
    }
    if (s.charAt(p) == '?') {
      dfs(p + 1, tmp + "0");
      dfs(p + 1, tmp + "1");
    } else {
      dfs(p + 1, tmp + s.charAt(p));
    }
  }

  private void upd(String tmp) {
    int a = 0;
    int b = 0;
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0 && tmp.charAt(i) == '1') {
        a++;
      }
      if (i % 2 == 1 && tmp.charAt(i) == '1') {
        b++;
      }
      if (a + 4 - i / 2 < b || a > b + 5 - (i + 1) / 2) {
        res = Math.min(res, i + 1);
      }
    }
  }

}
