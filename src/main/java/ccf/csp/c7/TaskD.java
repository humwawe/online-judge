package ccf.csp.c7;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    int[][][] b = new int[n][m][2];
    int t = in.nextInt();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        Arrays.fill(b[i][j], -1);
      }
    }
    for (int i = 0; i < t; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      int t1 = in.nextInt();
      int t2 = in.nextInt();
      b[x][y][0] = t1;
      b[x][y][1] = t2;
    }

    boolean[][][] dp = new boolean[n][m][305];
    dp[0][0][0] = true;
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0, 0});
    int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int cur = poll[2] + 1;
      if (cur > 300) {
        continue;
      }
      for (int[] f : fs) {
        int x = poll[0] + f[0];
        int y = poll[1] + f[1];

        if (x >= 0 && x < n && y >= 0 && y < m && !dp[x][y][cur]) {
          if (b[x][y][0] == -1 || cur < b[x][y][0] || cur > b[x][y][1]) {
            dp[x][y][cur] = true;
            queue.add(new int[]{x, y, cur});
          }
        }
      }
    }
    for (int i = 0; i < 305; i++) {
      if (dp[n - 1][m - 1][i]) {
        out.println(i);
        return;
      }
    }
    out.println(-1);

  }
}
