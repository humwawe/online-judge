package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ECountTheBlocks {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int mod = 998244353;
    long[] pow10 = new long[n + 1];
    pow10[0] = 1;
    for (int i = 1; i <= n; i++) {
      pow10[i] = pow10[i - 1] * 10 % mod;
    }

    for (int i = 1; i <= n; i++) {
      if (i == n) {
        out.println(10);
        return;
      }
      long x = pow10[n - i] * 18 + (n - i - 1) * pow10[n - i - 1] * 81;
      x %= mod;
      out.print(x, "");
    }
  }


}
