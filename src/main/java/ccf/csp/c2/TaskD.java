package ccf.csp.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int d = in.nextInt();
    int[][] mat = new int[n][n];
    int[][] dist = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], -1);
    }
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < m; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      mat[x][y] = 1;
      queue.add(new int[]{x, y});
      dist[x][y] = 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int base = 1005;
    for (int i = 0; i < k; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      mat[x][y] = 2;
      map.put(x * base + y, map.getOrDefault(x * base + y, 0) + in.nextInt());
    }
    for (int i = 0; i < d; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      mat[x][y] = 3;
    }
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      for (int[] f : fs) {
        int x = poll[0] + f[0];
        int y = poll[1] + f[1];
        if (x >= 0 && x < n && y >= 0 && y < n && mat[x][y] != 3 && dist[x][y] == -1) {
          dist[x][y] = dist[poll[0]][poll[1]] + 1;
          queue.add(new int[]{x, y});
        }
      }
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 2) {
          res += dist[i][j] * map.get(i * base + j);
        }
      }
    }
    out.println(res);
  }
}
