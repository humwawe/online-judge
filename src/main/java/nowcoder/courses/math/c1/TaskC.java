package nowcoder.courses.math.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  int N = (int) (1e6 + 5);
  int[] p;

  {
    p = sieveEratosthenes(N);
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int l = in.nextInt();
    int r = in.nextInt();

    boolean[] vis = new boolean[r - l + 5];
    if (l == 1) {
      vis[0] = true;
    }

    for (int i = 0; i < p.length; i++) {
      if (p[i] > r) {
        break;
      }
      long s = (long) l + (p[i] - l % p[i]) % p[i];
      if (s == p[i]) {
        s += p[i];
      }
      for (long j = s; j <= r; j += p[i]) {
        vis[(int) (j - l)] = true;
      }
    }
    long l1 = -1;
    long l2 = -1;
    long min = Long.MAX_VALUE;
    long max = 0;
    long c1 = 0;
    long c2 = 0;
    long d1 = 0;
    long d2 = 0;
    for (long i = l; i <= r; i++) {
      if (!vis[(int) (i - l)]) {
        l1 = l2;
        l2 = i;

        if (l1 != -1) {
          if (min > l2 - l1) {
            min = l2 - l1;
            c1 = l1;
            c2 = l2;
          }
          if (max < l2 - l1) {
            max = l2 - l1;
            d1 = l1;
            d2 = l2;
          }
        }
      }
    }

    if (l1 != -1) {
      out.printf("%d,%d are closest, %d,%d are most distant.\n", c1, c2, d1, d2);
    } else {
      out.println("There are no adjacent primes.");
    }


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
