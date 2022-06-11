package acwing.contest.weekly.c55;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int r = in.nextInt() - 1;
    int c = in.nextInt() - 1;
    int x = in.nextInt();
    int y = in.nextInt();
    char[][] a = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
      }
    }
    int[][] fs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    int res = 1;
    int[][][] dist = new int[n][m][2];
    dist[r][c][0] = 0;
    dist[r][c][1] = 0;
    boolean[][] vis = new boolean[n][m];
    vis[r][c] = true;
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{r, c});
    while (!queue.isEmpty()) {
      int[] cur = queue.pollFirst();
      for (int[] f : fs) {
        int nx = cur[0] + f[0];
        int ny = cur[1] + f[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny] && a[nx][ny] == '.') {
          if (f[0] == 0 && f[1] == -1) {
            if (dist[cur[0]][cur[1]][0] + 1 <= x) {
              dist[nx][ny][0] = dist[cur[0]][cur[1]][0] + 1;
              dist[nx][ny][1] = dist[cur[0]][cur[1]][1];
              vis[nx][ny] = true;
              queue.addLast(new int[]{nx, ny});
              res++;
            }
          } else if (f[0] == 0 && f[1] == 1) {
            if (dist[cur[0]][cur[1]][1] + 1 <= y) {
              dist[nx][ny][0] = dist[cur[0]][cur[1]][0];
              dist[nx][ny][1] = dist[cur[0]][cur[1]][1] + 1;
              vis[nx][ny] = true;
              queue.addLast(new int[]{nx, ny});
              res++;
            }
          } else {
            dist[nx][ny][0] = dist[cur[0]][cur[1]][0];
            dist[nx][ny][1] = dist[cur[0]][cur[1]][1];
            vis[nx][ny] = true;
            queue.addFirst(new int[]{nx, ny});
            res++;
          }
        }
      }
    }

    out.println(res);
  }
}
