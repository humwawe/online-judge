package atcoder.abc311;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class DGridIceFloor {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
      }
    }
    boolean[][][] vis = new boolean[n][m][4];
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < 4; i++) {
      queue.add(new int[]{1, 1, i});
      vis[1][1][i] = true;
    }

    int[] fx = new int[]{0, 0, 1, -1};
    int[] fy = new int[]{1, -1, 0, 0};
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];
      int d = poll[2];
      int nx = x + fx[d];
      int ny = y + fy[d];
      if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny][d]) {
        if (a[nx][ny] == '.') {
          queue.add(new int[]{nx, ny, d});
          vis[nx][ny][d] = true;
        } else {
          for (int i = 0; i < 4; i++) {
            if (!vis[x][y][i]) {
              queue.add(new int[]{x, y, i});
              vis[x][y][i] = true;
            }
          }
        }
      }
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int d = 0;
        for (int k = 0; k < 4; k++) {
          if (vis[i][j][k]) {
            d = 1;
            break;
          }
        }
        res += d;
      }
    }
    out.println(res);
  }
}
