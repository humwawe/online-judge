package leetcode.cc94;

/**
 * @author hum
 */
public class C4 {
  public int countAnagrams(String s) {

    String[] s1 = s.split(" ");
    int mod = (int) (1e9 + 7);

    long[][] fif = enumFAndIf(s.length(), mod);

    long res = 1;

    for (String str : s1) {
      int[] cnt = new int[26];
      int len = str.length();
      for (int i = 0; i < len; i++) {
        cnt[str.charAt(i) - 'a']++;
      }
      long tmp = 1;
      for (int i = 0; i < 26; i++) {
        tmp = tmp * c(len, cnt[i], mod, fif) % mod;
        len -= cnt[i];
      }
      res = res * tmp % mod;
    }
    return (int) res;
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
