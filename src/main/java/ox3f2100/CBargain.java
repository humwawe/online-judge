package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBargain {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int n = s.length();
    int mod = (int) (1e9 + 7);
    long sum = 0;
    long cur = 1;
    int base = 10;
    int idx = 1;
    long res = 0;
    for (int i = n - 1; i >= 0; i--) {
      int x = s.charAt(i) - '0';
      res += x * sum;
      res %= mod;
      res += (long) i * (i + 1) / 2 * x % mod * cur;
      res %= mod;
      sum += cur * idx;
      sum %= mod;
      cur *= base;
      cur %= mod;
      idx++;

    }
    out.println(res);
  }
}
