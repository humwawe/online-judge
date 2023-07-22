package atcoder.abc311;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AFirstABC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int res = 0;
    for (int i = 0; i < n; i++) {
      char c = in.nextCharacter();
      if (c == 'A') {
        res |= 1;
      } else if (c == 'B') {
        res |= 2;
      } else {
        res |= 4;
      }
      if (res == 7) {
        out.println(i + 1);
        return;
      }
    }

  }
}
