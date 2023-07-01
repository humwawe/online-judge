package atcoder.abc308;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class DSnukeMaze {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    String s = "snuke";
    int[] idx = new int[128];
    for (int i = 0; i < s.length(); i++) {
      idx[s.charAt(i)] = i;
    }

    int[][] mat = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        mat[i][j] = in.nextCharacter();
      }
    }
    if (mat[0][0] != 's') {
      out.println("No");
      return;
    }

    boolean[][] vis = new boolean[n][m];
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0});
    vis[0][0] = true;
    int[][] fs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int i = idx[mat[poll[0]][poll[1]]];
      for (int[] f : fs) {
        int nx = f[0] + poll[0];
        int ny = f[1] + poll[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
          int j = idx[mat[nx][ny]];
          if ((i + 1) % 5 == j) {
            queue.add(new int[]{nx, ny});
            vis[nx][ny] = true;
          }
        }
      }
    }
    if (vis[n - 1][m - 1]) {
      out.println("Yes");
    } else {
      out.println("No");
    }
  }
}

