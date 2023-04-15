package atcoder.abc298;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DWritingANumeral {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int mod = 998244353;

    int q = in.nextInt();
    long[] base = new long[q + 1];
    base[0] = 1L;
    for (int i = 1; i <= q; i++) {
      base[i] = base[i - 1] * 10 % mod;
    }
    long s = 1;
    StringBuilder sb = new StringBuilder("1");
    for (int c = 0; c < q; c++) {
      int t = in.nextInt();
      if (t == 1) {
        int x = in.nextInt();
        s = (s * 10 + x) % mod;
        sb.append(x);
      } else if (t == 2) {
        s = (s - (sb.charAt(0) - '0') * base[sb.length() - 1] % mod + mod) % mod;
        sb.deleteCharAt(0);
      } else {
        out.println(s);
      }
    }

  }
}
