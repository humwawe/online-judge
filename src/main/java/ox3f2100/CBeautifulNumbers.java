package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBeautifulNumbers {
  int a, b;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int mod = (int) (1e9 + 7);
    a = in.nextInt();
    b = in.nextInt();
    int n = in.nextInt();

    long[][] enumFAndIfs = enumFAndIf(n, mod);
    long res = 0;
    for (int i = 0; i <= n; i++) {
      int sum = i * a + (n - i) * b;
      if (check(sum)) {
        res += c(n, i, mod, enumFAndIfs);
        res %= mod;
      }
    }
    out.println(res);

  }

  private boolean check(int sum) {
    while (sum > 0) {
      int x = sum % 10;
      if (x != a && x != b) {
        return false;
      }
      sum /= 10;
    }
    return true;
  }

  long[][] enumFAndIf(int n, int mod) {
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
  long c(int a, int b, int mod, long[][] fif) {
    if (b < 0 || b > a) {
      return 0;
    }
    return fif[0][a] * fif[1][b] % mod * fif[1][a - b] % mod;
  }
}
