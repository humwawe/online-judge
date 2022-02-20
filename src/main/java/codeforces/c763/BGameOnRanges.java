package codeforces.c763;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class BGameOnRanges {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[n + 1][3];
    int[] d = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i][0] = in.nextInt();
      a[i][1] = in.nextInt();
      for (int j = a[i][0]; j <= a[i][1]; j++) {
        a[i][2] += j;
      }
      d[i] = a[i][1] - a[i][0];
    }
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] vis = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      if (a[i][0] == a[i][1]) {
        out.println(a[i][0] + " " + a[i][1] + " " + a[i][2]);
        queue.add(i);
        vis[i] = true;
      }
    }
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      for (int i = 1; i <= n; i++) {
        if (vis[i]) {
          continue;
        }
        if (a[i][0] <= a[cur][2] && a[cur][2] <= a[i][1]) {
          a[i][2] -= a[cur][2];
          d[i]--;
        }
        if (d[i] == 0) {
          queue.add(i);
          vis[i] = true;
          out.println(a[i][0] + " " + a[i][1] + " " + a[i][2]);
        }
      }
    }
    out.println();
  }
}
