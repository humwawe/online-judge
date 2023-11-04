package ccf.csp.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskE {
  long n, m;
  int[][] w;
  int mod = (int) (1e9 + 7);
  public final long m2 = (long) mod * mod;
  public final long BIG = 8L * m2;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextLong();
    m = in.nextInt();
    w = new int[1 << m][1 << m];

    for (int i = 0; i < 1 << m; i++) {
      dfs(i, 0, 0);
    }

    int[][] res = new int[1 << m][1 << m];
    res[0][(1 << m) - 1] = 1;
    int[][] qp = qp(w, n, mod);
    int[][] mul = mul(res, qp, mod);
    out.println(mul[0][(1 << m) - 1]);
  }

  int[][] mul(int[][] a, int[][] b, int p) {
    int l = 1 << m;
    int[][] c = new int[l][l];
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        for (int k = 0; k < l; k++) {
          c[i][j] = (int) ((c[i][j] + (long) a[i][k] * b[k][j]) % p);
        }
      }
    }
    return c;
  }

  // 快速幂
  int[][] qp(int[][] a, long k, int p) {
    int l = 1 << m;
    int[][] c = new int[l][l];
    for (int i = 0; i < l; i++) {
      c[i][i] = 1;
    }
    while (k > 0) {
      if ((k & 1) == 1) {
        c = mul(c, a, p);
      }
      k >>= 1;
      a = mul(a, a, p);
    }
    return c;
  }


  private void dfs(int x, int y, int i) {
    if (i == m) {
      w[x][y]++;
      return;
    }
    if ((x >> i & 1) == 1) {
      dfs(x, y, i + 1);
      return;
    }

    if ((y >> i & 1) == 0 && i - 1 >= 0 && (y >> i - 1 & 1) == 0) {
      dfs(x, y + (1 << i) + (1 << i - 1), i + 1);
    }

    if ((y >> i & 1) == 0 && i + 1 < m && (y >> i + 1 & 1) == 0) {
      dfs(x, y + (1 << i) + (1 << i + 1), i + 1);
    }

    if (i + 1 < m && (x >> i + 1 & 1) == 0) {
      if ((y >> i & 1) == 0) {
        dfs(x, y + (1 << i), i + 2);
      }
      if ((y >> i + 1 & 1) == 0) {
        dfs(x, y + (1 << i + 1), i + 2);
      }
    }
  }
}
