package nowcoder.courses.dp.c8;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskG {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int inf = (int) 1e9;
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], inf);
      dist[i][i] = 0;
    }

    for (int i = 0; i < m; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      int c = in.nextInt();
      dist[a][b] = Math.min(dist[a][b], c);
      dist[b][a] = Math.min(dist[b][a], c);
    }
    int lim = 1 << n;
    int[] to = new int[lim];
    for (int i = 0; i < lim; i++) {
      for (int j = 0; j < n; j++) {
        if ((i >> j & 1) == 1) {
          for (int k = 0; k < n; k++) {
            if (dist[j][k] != inf) {
              to[i] |= 1 << k;
            }
          }
        }
      }
    }

    int[][] dp = new int[lim][n];
    for (int i = 0; i < lim; i++) {
      Arrays.fill(dp[i], inf);
    }
    for (int i = 0; i < n; i++) {
      dp[1 << i][0] = 0;
    }
    for (int st = 1; st < lim; st++) {
      for (int sub = (st - 1) & st; sub > 0; sub = (sub - 1) & st) {
        if ((to[sub] & st) == st) {
          int remain = sub ^ st;
          int cost = 0;
          for (int i = 0; i < n; i++) {
            if ((remain >> i & 1) == 1) {
              int t = inf;
              for (int j = 0; j < n; j++) {
                if ((sub >> j & 1) == 1) {
                  t = Math.min(t, dist[i][j]);
                }
              }
              cost += t;
            }
          }

          for (int i = 1; i < n; i++) {
            dp[st][i] = Math.min(dp[st][i], dp[sub][i - 1] + cost * i);
          }
        }
      }
    }

    int res = inf;
    for (int i = 0; i < n; i++) {
      res = Math.min(res, dp[lim - 1][i]);
    }
    out.println(res);

  }
}
