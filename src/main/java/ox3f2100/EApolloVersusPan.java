package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EApolloVersusPan {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] a = new long[n];
    long[] cnt = new long[60];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
      for (int j = 0; j < 60; ++j) {
        cnt[j] += a[i] >> j & 1;
      }
    }

    long res = 0;
    int mod = (int) (1e9 + 7);
    for (int i = 0; i < n; ++i) {
      long x = 0, y = 0;
      for (int j = 0; j < 60; ++j) {
        long t = (1L << j) % mod * cnt[j];
        if ((a[i] >> j & 1) == 1) {
          x = (x + t) % mod;
          y = (y + (1L << j) % mod * n) % mod;
        } else {
          y = (y + t) % mod;
        }
      }
      res = (res + x * y % mod) % mod;
    }
    out.println(res);
  }
}
