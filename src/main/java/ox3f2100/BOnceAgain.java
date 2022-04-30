package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BOnceAgain {
  int n;
  long t;
  long[][] a;
  long inf = (long) 1e15;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    t = in.nextInt();
    int[] x = new int[n];
    a = new long[n][n];
    for (int i = 0; i < n; i++) {
      x[i] = in.nextInt();
    }
    for (int s = 0; s < n; ++s) {
      for (int i = 0; i < n; ++i) {
        if (x[i] < x[s]) {
          a[s][i] = -inf;
        } else {
          a[s][i] = 1;
          for (int j = 0; j < i; ++j) {
            if (x[j] <= x[i]) {
              a[s][i] = Math.max(a[s][i], a[s][j] + 1);
            }
          }
        }
      }
    }

    long[][] c = qp(a, t);
    long res = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        res = Math.max(res, c[i][j]);
      }
    }
    out.println(res);

  }

  long[][] mul(long[][] a, long[][] b) {
    long[][] c = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        c[i][j] = -inf;
        for (int k = 0; k < n; k++) {
          c[i][j] = Math.max(c[i][j], a[i][k] + b[k][j]);
        }
      }
    }
    return c;
  }

  long[][] qp(long[][] a, long k) {
    long[][] c = new long[n][n];
    while (k > 0) {
      if ((k & 1) == 1) {
        c = mul(c, a);
      }
      k >>= 1;
      a = mul(a, a);
    }
    return c;
  }
}
