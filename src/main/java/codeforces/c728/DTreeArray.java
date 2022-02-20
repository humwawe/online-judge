package codeforces.c728;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTreeArray {
  int n;
  int mod = (int) (1e9 + 7);

  // 考虑每个逆序对出现的概率
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int[][] dist = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          dist[i][j] = 0;
        } else {
          dist[i][j] = 0x3f3f3f3f;
        }
      }
    }
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      dist[a][b] = 1;
      dist[b][a] = 1;
    }
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }

    long[][] dp = new long[n][n];
    long inv2 = inv(2);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          dp[i][j] = 0;
          continue;
        }
        if (j == 0) {
          dp[i][j] = 1;
          continue;
        }
        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) * inv2 % mod;
      }
    }
    long res = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        for (int k = 1; k <= n; k++) {
          int x = dist[i][k];
          int y = dist[j][k];
          int d = (x + y - dist[i][j]) / 2;
          x -= d;
          y -= d;
          res = (res + dp[x][y]) % mod;
        }
      }
    }
    long invn = inv(n);
    out.println(res * invn % mod);

  }

  long inv(int x) {
    return qmi(x, mod - 2, mod);
  }

  long qmi(int m, int k, int p) {
    long res = 1 % p, t = m;
    while (k > 0) {
      if ((k & 1) == 1) {
        res = res * t % p;
      }
      t = t * t % p;
      k >>= 1;
    }
    return res % p;
  }

}
