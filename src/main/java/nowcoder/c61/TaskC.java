package nowcoder.c61;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int r1 = in.nextInt();
    int r2 = in.nextInt();
    int[] p1 = new int[2];
    int[] p2 = new int[2];
    char[][] a = new char[n][m];
    int[][] dist1 = new int[n][m];
    int[][] dist2 = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dist1[i][j] = -1;
        dist2[i][j] = -1;
        a[i][j] = in.nextCharacter();
        if (a[i][j] == 'M') {
          p1[0] = i;
          p1[1] = j;
          dist1[i][j] = 0;
        }
        if (a[i][j] == 'P') {
          p2[0] = i;
          p2[1] = j;
          dist2[i][j] = 0;
        }
      }
    }
    int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(p1);
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int[] f : fs) {
        int x = cur[0] + f[0];
        int y = cur[1] + f[1];
        if (x >= 0 && x < n && y >= 0 && y < m && dist1[x][y] == -1 && a[x][y] != '*') {
          dist1[x][y] = dist1[cur[0]][cur[1]] + 1;
          queue.add(new int[]{x, y});
        }
      }
    }

    queue.add(p2);
    int res = (int) 1e8;
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int[] f : fs) {
        int x = cur[0] + f[0];
        int y = cur[1] + f[1];
        if (x >= 0 && x < n && y >= 0 && y < m && helper(x, y, p2) <= r1 && a[x][y] != '*' && dist2[x][y] == -1) {
          dist2[x][y] = dist2[cur[0]][cur[1]] + 1;
          queue.add(new int[]{x, y});
          if (helper(x, y, p1) <= r2 && dist1[x][y] != -1) {
            res = Math.min(res, dist1[x][y] + dist2[x][y]);
          }
        }
      }
    }
    if (res == (int) 1e8) {
      out.println(-1);
    } else {
      out.println(res);
    }

  }

  private int helper(int x, int y, int[] p2) {
    return Math.abs(x - p2[0]) + Math.abs(y - p2[1]);
  }
}
