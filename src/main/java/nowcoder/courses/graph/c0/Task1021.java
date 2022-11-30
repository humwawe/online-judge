package nowcoder.courses.graph.c0;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Task1021 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    char[][] a = new char[n][n];
    int[] s = new int[2];
    int[] t = new int[2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextCharacter();
        if (a[i][j] == 'A') {
          s[0] = i;
          s[1] = j;
        }
        if (a[i][j] == 'B') {
          t[0] = i;
          t[1] = j;
        }
      }
    }

    int inf = (int) 1e8;
    int[][][] dist = new int[n][n][4];
    boolean[][][] vis = new boolean[n][n][4];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Arrays.fill(dist[i][j], inf);
      }
    }

    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
    for (int i = 0; i < 4; i++) {
      dist[s[0]][s[1]][i] = 0;
      queue.add(new int[]{dist[s[0]][s[1]][i], s[0], s[1], i});
    }

    int[][] fs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int d = cur[0];
      int x = cur[1];
      int y = cur[2];
      int f = cur[3];
      if (vis[x][y][f]) {
        continue;
      }
      vis[x][y][f] = true;
      for (int i = 0; i < 4; i++) {
        int nx = x + fs[i][0];
        int ny = y + fs[i][1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < n && a[nx][ny] != 'x') {
          if (i == f) {
            if (dist[nx][ny][i] > d) {
              dist[nx][ny][i] = d;
              queue.add(new int[]{dist[nx][ny][i], nx, ny, i});
            }
          } else if (Math.abs(i - f) != 2) {
            if (dist[nx][ny][i] > d + 1) {
              dist[nx][ny][i] = d + 1;
              queue.add(new int[]{dist[nx][ny][i], nx, ny, i});
            }
          }
        }
      }
    }

    int res = inf;
    for (int i = 0; i < 4; i++) {
      res = Math.min(res, dist[t[0]][t[1]][i]);
    }
    out.println(res == inf ? -1 : res);
  }
}
