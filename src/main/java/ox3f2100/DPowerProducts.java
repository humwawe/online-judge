package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DPowerProducts {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int N = (int) (1e5 + 5);
    int k = in.nextInt();
    int[] lpf = enumLowestPrimeFactors(N);
    int[] cnt = new int[N];
    long res = 0;
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      int[][] ps = factorFast(x, lpf);
      int t = 1;
      long need = 1;
      for (int[] p : ps) {
        int pr = p[0];
        int c1 = p[1] % k;
        int c2 = (k - c1) % k;
        for (int j = 0; j < c1; j++) {
          t *= pr;
        }
        for (int j = 0; j < c2 && need < N; j++) {
          need *= pr;
        }
      }
      if (need < N) {
        res += cnt[(int) need];
      }
      cnt[t]++;
    }
    out.println(res);
  }


  public int[][] factorFast(int n, int[] lpf) {
    int[][] f = new int[9][];
    int q = 0;
    while (lpf[n] > 0) {
      int p = lpf[n];
      if (q == 0 || p != f[q - 1][0]) {
        f[q++] = new int[]{p, 1};
      } else {
        f[q - 1][1]++;
      }
      n /= p;
    }
    return Arrays.copyOf(f, q);
  }

  public int[] enumLowestPrimeFactors(int n) {
    int tot = 0;
    int[] lpf = new int[n + 1];
    int u = n + 32;
    double lu = Math.log(u);
    int[] primes = new int[(int) (u / lu + u / lu / lu * 1.5)];
    for (int i = 2; i <= n; i++) {
      lpf[i] = i;
    }
    for (int p = 2; p <= n; p++) {
      if (lpf[p] == p) {
        primes[tot++] = p;
      }
      int tmp;
      for (int i = 0; i < tot && primes[i] <= lpf[p] && (tmp = primes[i] * p) <= n; i++) {
        lpf[tmp] = primes[i];
      }
    }
    return lpf;
  }
}
