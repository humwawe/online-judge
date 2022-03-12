package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPlasticineZebra {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    s += s;
    int cnt = 1;
    int res = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        cnt = 1;
      } else {
        cnt++;
        res = Math.max(res, cnt);
      }
    }
    out.println(Math.min(s.length() / 2, res));
  }
}
