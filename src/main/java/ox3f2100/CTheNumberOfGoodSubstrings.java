package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTheNumberOfGoodSubstrings {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int len = s.length();
    int cnt = 0;
    int res = 0;
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '0') {
        cnt++;
      } else {
        int cur = 0;
        for (int j = i; j < len; j++) {
          cur = cur * 2 + (s.charAt(j) - '0');
          if (cur <= cnt + j - i + 1) {
            res++;
          } else {
            break;
          }
        }
        cnt = 0;
      }
    }
    out.println(res);
  }
}
