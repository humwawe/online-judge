package ccf.csp.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TaskD {
  int n, m, k;
  long r;
  long[][] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    k = in.nextInt();
    r = in.nextInt();
    a = new long[n + m][2];
    for (int i = 0; i < n + m; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
    }
    int inf = (int) 1e5;
    int[][] dp = new int[n + m][k + 1];
    for (int i = 0; i < n + m; i++) {
      Arrays.fill(dp[i], inf);
    }
    dp[0][0] = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    boolean[] vis = new boolean[n + m];
    vis[0] = true;
    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      vis[poll] = false;

      for (int i = 1; i < n + m; i++) {
        if (i == poll) {
          continue;
        }
        if (dist(poll, i)) {
          boolean f = false;
          if (i >= n) {
            for (int j = 0; j < k; j++) {
              if (dp[poll][j] + 1 < dp[i][j + 1]) {
                dp[i][j + 1] = dp[poll][j] + 1;
                f = true;
              }
            }

          } else {
            for (int j = 0; j <= k; j++) {
              if (dp[poll][j] + 1 < dp[i][j]) {
                dp[i][j] = dp[poll][j] + 1;
                f = true;
              }
            }
          }
          if (f) {
            queue.add(i);
          }
        }
      }
    }
    int res = inf;
    for (int i = 0; i <= k; i++) {
      res = Math.min(res, dp[1][i]);
    }
    out.println(res - 1);
  }

  private boolean dist(int poll, int i) {
    return (a[poll][0] - a[i][0]) * (a[poll][0] - a[i][0]) + (a[poll][1] - a[i][1]) * (a[poll][1] - a[i][1]) <= r * r;
  }
}
