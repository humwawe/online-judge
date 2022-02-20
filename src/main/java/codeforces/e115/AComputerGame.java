package codeforces.e115;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class AComputerGame {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int row = 2;
    int[][] mat = new int[2][n];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = in.nextCharacter();
      }
    }
    boolean[][] vis = new boolean[2][n];
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0});
    vis[0][0] = true;
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      if (cur[0] == 1 && cur[1] == n - 1) {
        out.println("YES");
        return;
      }
      for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
          if (i == 0 && j == 0) {
            continue;
          }
          int x = cur[0] + i;
          int y = cur[1] + j;
          if (x >= 0 && x < 2 && y >= 0 && y < n && !vis[x][y] && mat[x][y] == '0') {
            queue.add(new int[]{x, y});
            vis[x][y] = true;
          }
        }
      }
    }
    out.println("NO");
  }
}
