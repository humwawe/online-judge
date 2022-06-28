package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class E2CloseTuplesHardVersion {
  int mod = (int) (1e9 + 7);
  long[][] enumFAndIf;

  {
    enumFAndIf = enumFAndIf((int) (2e5 + 5), mod);
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
//    intRadixSort(a);
    Arrays.sort(a);
    int j = 0;
    long res = 0;
    for (int i = 0; i < n; i++) {
      while (j + 1 < n && a[j + 1] - a[i] <= k) {
        j++;
      }
      int len = j - i + 1;
      res += c(len - 1, m - 1, mod, enumFAndIf);
      res %= mod;
    }
    out.println(res);
  }

  public void intRadixSort(int[] a) {
    int fr = 0;
    int to = a.length;
    int[] c0 = new int[0x101];
    int[] c1 = new int[0x101];
    int[] c2 = new int[0x101];
    int[] c3 = new int[0x101];
    c0[0] = c1[0] = c2[0] = c3[0] = fr;
    for (int i = fr; i < to; i++) {
      int v = a[i];
      c0[(v & 0xff) + 1]++;
      c1[(v >>> 8 & 0xff) + 1]++;
      c2[(v >>> 16 & 0xff) + 1]++;
      c3[(v >>> 24 ^ 0x80) + 1]++;
    }
    for (int i = 0; i < 0x100; i++) {
      c0[i + 1] += c0[i];
      c1[i + 1] += c1[i];
      c2[i + 1] += c2[i];
      c3[i + 1] += c3[i];
    }
    int[] b = new int[a.length];
    for (int i = fr; i < to; i++) {
      int v = a[i];
      b[c0[v & 0xff]++] = v;
    }
    for (int i = fr; i < to; i++) {
      int v = b[i];
      a[c1[v >>> 8 & 0xff]++] = v;
    }
    for (int i = fr; i < to; i++) {
      int v = a[i];
      b[c2[v >>> 16 & 0xff]++] = v;
    }
    for (int i = fr; i < to; i++) {
      int v = b[i];
      a[c3[v >>> 24 ^ 0x80]++] = v;
    }
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
