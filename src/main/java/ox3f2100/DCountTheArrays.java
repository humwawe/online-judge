package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DCountTheArrays {
  int n, m;
  int mod = 998244353;
  int N = (int) (2e5 + 5);

  public void solve(int testNumber, InputReader in, OutputWriter out) {


    n = in.nextInt();
    m = in.nextInt();
    long[][] fif = enumFAndIf(N);

    long res = 0;

    long base = (n - 2) * c(m, n - 1, fif) % mod;
    for (int i = 2; i <= n - 1; i++) {
      res = (res + base * (c(n - 3, i - 2, fif))) % mod;
    }
    out.println(res);
  }


  long[][] enumFAndIf(int n) {
    long[] f = new long[n + 1];
    long[] invf = new long[n + 1];
    f[0] = 1;
    for (int i = 1; i <= n; i++) {
      f[i] = f[i - 1] * i % mod;
    }
    invf[n] = invl(f[n], mod);
    for (int i = n - 1; i >= 0; i--) {
      invf[i] = invf[i + 1] * (i + 1) % mod;
    }
    return new long[][]{f, invf};
  }

  // a在mod下的逆元，mod可不为质数
  long invl(long a, long mod) {
    long b = mod;
    long p = 1, q = 0;
    while (b > 0) {
      long c = a / b;
      long d;
      d = a;
      a = b;
      b = d % b;
      d = p;
      p = q;
      q = d - c * q;
    }
    return p < 0 ? p + mod : p;
  }

  // 预处理 enumFAndIf 后求组合数
  long c(int a, int b, long[][] fif) {
    if (b < 0 || b > a) {
      return 0;
    }
    return fif[0][a] * fif[1][b] % mod * fif[1][a - b] % mod;
  }
}
