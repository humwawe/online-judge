package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DTwoDivisors {
  int N = (int) (1e7 + 5);
  int[] primes = new int[N + 1];
  int[] sieve = new int[N + 1];

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    getPrimes3(N);

    int n = in.nextInt();
    int[] a = new int[n];
    int[] res1 = new int[n];
    int[] res2 = new int[n];
    Arrays.fill(res1, -1);
    Arrays.fill(res2, -1);
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      int t = x;
      int p = sieve[x];
      while (t % p == 0) {
        t /= p;
      }
      if (t > 1) {
        res1[i] = x / t;
        res2[i] = t;
      }
    }
    out.println(res1);
    out.println(res2);
  }

  void getPrimes3(int n) {
    int cnt = 0;
    for (int i = 2; i <= n; i++) {
      if (sieve[i] == 0) {
        sieve[i] = i;
        primes[cnt++] = i;
      }
      for (int j = 0; j < cnt; j++) {
        if (primes[j] > n / i || primes[j] > sieve[i]) {
          break;
        }
        sieve[i * primes[j]] = primes[j];
      }
    }
  }
}
