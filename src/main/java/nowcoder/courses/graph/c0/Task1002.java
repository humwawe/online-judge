package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Task1002 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] e = new int[n + 1][n + 1];
    int[] inDep = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int k = in.nextInt();
      boolean[] vis = new boolean[n + 1];
      int s = -1;
      int t = -1;
      for (int j = 0; j < k; j++) {
        int x = in.nextInt();
        vis[x] = true;
        if (s == -1) {
          s = x;
        }
        t = x;
      }
      for (int j = s; j <= t; j++) {
        if (vis[j]) {
          for (int l = s; l <= t; l++) {
            if (!vis[l]) {
              if (e[j][l] == 0) {
                e[j][l] = 1;
                inDep[l]++;
              }
            }
          }
        }
      }
    }

    Queue<Integer> queue = new ArrayDeque<>();
    int[] dist = new int[n + 1];
    Arrays.fill(dist, (int) 1e8);
    for (int i = 1; i <= n; i++) {
      if (inDep[i] == 0) {
        queue.add(i);
        dist[i] = 1;
      }
    }

    while (!queue.isEmpty()) {
      int u = queue.poll();
      for (int i = 1; i <= n; i++) {
        if (e[u][i] == 1) {
          if (--inDep[i] == 0) {
            queue.add(i);
            dist[i] = dist[u] + 1;
          }
        }
      }
    }

    int res = 0;
    for (int i = 1; i <= n; i++) {
      res = Math.max(res, dist[i]);
    }
    out.println(res);
  }
}
