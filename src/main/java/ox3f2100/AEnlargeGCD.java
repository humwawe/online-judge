package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AEnlargeGCD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = 15005;
    int[] primes = sieveEratosthenes(N);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < primes.length; i++) {
      map.put(primes[i], i);
    }
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int g = a[0];
    for (int i = 0; i < n; i++) {
      g = gcd(g, a[i]);
    }

    for (int i = 0; i < n; i++) {
      a[i] /= g;
    }


    int[] cnt = new int[primes.length];
    Map<Integer, Integer> map2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < primes.length && (long) primes[j] * primes[j] <= a[i]; j++) {
        int p = primes[j];
        if (a[i] % p == 0) {
          cnt[j]++;
          while (a[i] % p == 0) {
            a[i] /= p;
          }
        }
      }
      if (a[i] > 1) {
        if (map.containsKey(a[i])) {
          cnt[map.get(a[i])]++;
        }
        map2.put(a[i], map2.getOrDefault(a[i], 0) + 1);
      }

    }

    int res = n;
    for (int i = 0; i < primes.length; i++) {
      res = Math.min(res, n - cnt[i]);
    }
    for (Integer integer : map2.keySet()) {
      res = Math.min(res, n - map2.get(integer));
    }
    out.println(res == n ? -1 : res);
  }

  int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }


  int[] sieveEratosthenes(int n) {
    if (n <= 32) {
      int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
      for (int i = 0; i < primes.length; i++) {
        if (n < primes[i]) {
          return Arrays.copyOf(primes, i);
        }
      }
      return primes;
    }

    int u = n + 32;
    double lu = Math.log(u);
    int[] ret = new int[(int) (u / lu + u / lu / lu * 1.5)];
    ret[0] = 2;
    int pos = 1;

    int[] isnp = new int[(n + 1) / 32 / 2 + 1];
    int sup = (n + 1) / 32 / 2 + 1;

    int[] tprimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    for (int tp : tprimes) {
      ret[pos++] = tp;
      int[] ptn = new int[tp];
      for (int i = (tp - 3) / 2; i < tp << 5; i += tp) {
        ptn[i >> 5] |= 1 << (i & 31);
      }
      for (int j = 0; j < sup; j += tp) {
        for (int i = 0; i < tp && i + j < sup; i++) {
          isnp[j + i] |= ptn[i];
        }
      }
    }

    // 3,5,7
    // 2x+3=n
    int[] magic = {0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4, 13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17, 9, 6, 16, 5, 15, 14};
    int h = n / 2;
    for (int i = 0; i < sup; i++) {
      for (int j = ~isnp[i]; j != 0; j &= j - 1) {
        int pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
        int p = 2 * pp + 3;
        if (p > n) {
          break;
        }
        ret[pos++] = p;
        if ((long) p * p > n) {
          continue;
        }
        for (int q = (p * p - 3) / 2; q <= h; q += p) {
          isnp[q >> 5] |= 1 << q;
        }
      }
    }

    return Arrays.copyOf(ret, pos);
  }
}
