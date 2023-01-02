package codeforces.c841;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EGraphCost {
  int N = (int) (1e6 + 5);
  long[] sum = new long[N + 1];

  {
    int[] eulers = getEulers(N);
    for (int i = 2; i <= N; i++) {
      sum[i] += sum[i - 1] + eulers[i];
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long m = in.nextLong();
    long[] cnt = new long[n];
    for (int i = 1; i < n; i++) {
      int g = i + 1;
      cnt[i] = sum[n / g];
      if (cnt[i] < i) {
        cnt[i] = 0;
      }
    }

    long res = 0;
    for (int i = n - 1; i > 0; i--) {

      if (cnt[i] >= i) {
        long c = Math.min(cnt[i], m) / i;
        res += (long) (i + 1) * c;
        m -= i * c;
        cnt[i] -= i * c;
      }
      if (m <= 0) {
        out.println(res);
        return;
      }

    }
    out.println(-1);

  }

  int[] getEulers(int n) {
    int[] primes = new int[n + 1];
    int[] euler = new int[n + 1];
    boolean[] st = new boolean[n + 1];
    int cnt = 0;
    euler[1] = 1;
    for (int i = 2; i <= n; i++) {
      if (!st[i]) {
        primes[cnt++] = i;
        euler[i] = i - 1;
      }
      for (int j = 0; primes[j] <= n / i; j++) {
        int t = primes[j] * i;
        st[t] = true;
        if (i % primes[j] == 0) {
          euler[t] = euler[i] * primes[j];
          break;
        }
        euler[t] = euler[i] * (primes[j] - 1);
      }
    }
    return euler;
  }
}
