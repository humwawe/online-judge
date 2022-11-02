package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BShortestCycle {
  int inf = (int) 1e8;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextLong();
      if (a[i] == 0) {
        i--;
        n--;
      }
    }

    if (n > 128) {
      out.println(3);
      return;
    }
    int res = floydMinCircle(a, n);
    if (res == inf) {
      out.println(-1);
    } else {
      out.println(res);
    }

  }

  int floydMinCircle(long[] a, int n) {
    // 最短路矩阵
    int[][] dist = new int[n][n];
    int[][] val = new int[n][n];

    // 初始化最短路矩阵
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          dist[i][j] = val[i][j] = 0;
        } else {
          if ((a[i] & a[j]) != 0) {
            dist[i][j] = val[i][j] = 1;
          } else {
            dist[i][j] = val[i][j] = inf;
          }
        }
      }
    }

    int res = inf;
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < k; i++) {
        for (int j = 0; j < i; j++) {
          // 更新答案
          res = Math.min(res, dist[i][j] + val[i][k] + val[k][j]);
        }
      }
      // 正常的 floyd 更新最短路矩阵
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }
    return res;
  }
}
