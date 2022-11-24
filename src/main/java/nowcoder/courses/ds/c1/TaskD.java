package nowcoder.courses.ds.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  int mod = (int) (1e9 + 7);

  int N = 10;
  long[] t = new long[N];
  int k, n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int m = in.nextInt();
    int q = in.nextInt();
    long[] d = new long[n + N + 5];
    for (int i = 1; i <= n; i++) {
      d[i] = in.nextInt();
    }
    diff(d, n, 6);

    for (int i = 0; i < m; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      k = in.nextInt();
      for (int j = 0; j <= k; j++) {
        t[j] = in.nextInt();
      }
      long[] f = helper(1);
      long[] g = helper(1 + r - l + 1);

      diff(f, N, 6);
      diff(g, N, 6);

      for (int j = 0; j < N; j++) {
        d[l + j] = (d[l + j] + f[j + 1]) % mod;
        d[r + 1 + j] = (d[r + 1 + j] - g[j + 1] + mod) % mod;
      }
    }


    sum(d, 7);
    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      out.println((d[r] - d[l - 1] + mod) % mod);
    }
  }

  private void sum(long[] d, int cnt) {
    for (int i = 0; i < cnt; i++) {
      for (int j = 1; j <= n; j++) {
        d[j] += d[j - 1];
        d[j] %= mod;
      }

    }
  }

  private void diff(long[] f, int len, int cnt) {
    for (int i = 0; i < cnt; i++) {
      for (int j = len; j >= 1; j--) {
        f[j] = (f[j] - f[j - 1] + mod) % mod;
      }

    }
  }

  private long[] helper(int start) {
    long[] res = new long[N + 1];
    for (int i = 1; i <= N; i++) {
      res[i] = fun(start + i - 1);
    }
    return res;
  }

  private long fun(int x) {
    long res = 0;
    long tmp = 1;
    for (int i = 0; i <= k; i++) {
      res += t[k - i] * tmp;
      tmp *= x;
      res %= mod;
      tmp %= mod;
    }
    return res;
  }
}
