package acwing.contest.weekly.c23;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TaskB {
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int r1 = in.nextInt();
    int c1 = in.nextInt();
    int r2 = in.nextInt();
    int c2 = in.nextInt();
    char[][] a = new char[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        a[i][j] = in.nextCharacter();
      }
    }
    boolean[][] vis = new boolean[n + 1][n + 1];
    List<int[]> list1 = new ArrayList<>();
    List<int[]> list2 = new ArrayList<>();
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{r1, c1});
    vis[r1][c1] = true;
    list1.add(new int[]{r1, c1});
    int[][] fs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      if (cur[0] == r2 && cur[1] == c2) {
        out.println(0);
        return;
      }
      for (int[] f : fs) {
        int x = cur[0] + f[0];
        int y = cur[1] + f[1];
        if (x >= 1 && x < n + 1 && y >= 1 && y < n + 1 && !vis[x][y] && a[x][y] != '1') {
          queue.add(new int[]{x, y});
          vis[x][y] = true;
          list1.add(new int[]{x, y});
        }
      }
    }
    queue.clear();
    queue.add(new int[]{r2, c2});
    vis[r2][c2] = true;
    list2.add(new int[]{r2, c2});
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int[] f : fs) {
        int x = cur[0] + f[0];
        int y = cur[1] + f[1];
        if (x >= 1 && x < n + 1 && y >= 1 && y < n + 1 && !vis[x][y] && a[x][y] != '1') {
          queue.add(new int[]{x, y});
          vis[x][y] = true;
          list2.add(new int[]{x, y});
        }
      }
    }
    int res = (int) 1e8;
    for (int[] l1 : list1) {
      for (int[] l2 : list2) {
        res = Math.min(res, (l1[0] - l2[0]) * (l1[0] - l2[0]) + (l1[1] - l2[1]) * (l1[1] - l2[1]));
      }
    }
    out.println(res);
  }
}
