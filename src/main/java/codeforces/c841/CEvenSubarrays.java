package codeforces.c841;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CEvenSubarrays {
  List<Integer> list = new ArrayList<>();
  int N = (int) 3e5 + 5;
  int[] map = new int[N];

  {
    list.add(0);

    int[] lpf = enumLowestPrimeFactors(N);
    for (int i = 1; i < N; i++) {
      if (!factorFast(i, lpf)) {
        list.add(i);
      }
    }

  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    map[0] = 1;
    long res = 0;
    int sum = 0;
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum ^= a[i];
      for (Integer j : list) {
        int tmp = sum ^ j;
        if (tmp < N) {
          res += map[tmp];
        }
      }
      map[sum]++;
    }
    sum = 0;
    for (int i = 0; i < n; i++) {
      sum ^= a[i];
      map[sum] = 0;
    }
    out.println((long) n * (n + 1) / 2 - res);
  }

  public boolean factorFast(int n, int[] lpf) {
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
    for (int i = 0; i < q; i++) {
      if (f[i][1] % 2 == 1) {
        return true;
      }
    }
    return false;

  }

  // lpf[i]每个数的最小质因子
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
