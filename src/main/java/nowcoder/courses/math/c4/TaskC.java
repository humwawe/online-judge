package nowcoder.courses.math.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    if (n == 1) {
      out.println(0);
      return;
    }
    int mod = 1000000007;
    long res = 0;
    long sign = 1;
    long[][] fif = enumFAndIf(2 * n, mod);

    //    CombinationMath.initMod(mod);
    for (int i = 0; i <= n; i++) {
      //      res += sign * CombinationMath.comb(n, i) % mod * CombinationMath.fact(2 * n - i - 1) % mod;
      res += sign * c(n, i, mod, fif) % mod * fif[0][2 * n - i - 1] % mod;
      res %= mod;
      sign = sign * -2 % mod;
    }
    out.println((res + mod) % mod);
  }

  // 返回的ret[0] 为fact数组（f）
  // 返回的ret[1] 为infact数组（invf）
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
