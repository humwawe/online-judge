package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class DSolveTheMaze {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] a = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.nextCharacter();
      }
    }
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 'B') {
          for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < n && y >= 0 && y < m) {
              if (a[x][y] == 'G') {
                out.println("No");
                return;
              }
              if (a[x][y] == '.') {
                a[x][y] = '#';
              }
            }
          }
        }
      }
    }
    boolean[][] vis = new boolean[n][m];
    Queue<int[]> queue = new ArrayDeque<>();
    if (a[n - 1][m - 1] != '#') {
      queue.add(new int[]{n - 1, m - 1});
      vis[n - 1][m - 1] = true;
    }
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int[] f : fs) {
        int x = cur[0] + f[0];
        int y = cur[1] + f[1];
        if (x >= 0 && x < n && y >= 0 && y < m) {
          if (!vis[x][y] && (a[x][y] == '.' || a[x][y] == 'G')) {
            vis[x][y] = true;
            queue.add(new int[]{x, y});
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 'G' && !vis[i][j]) {
          out.println("No");
          return;
        }
      }
    }
    out.println("Yes");

  }

}
