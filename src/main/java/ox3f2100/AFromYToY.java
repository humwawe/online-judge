package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AFromYToY {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int k = in.nextInt();
    for (int i = 0; i < 26; i++) {
      int cnt = 0;
      while ((cnt + 1) * cnt / 2 <= k) {
        cnt++;
      }
      k -= cnt * (cnt - 1) / 2;
      out.print(((char) ('a' + i) + "").repeat(cnt));
    }
  }
}
