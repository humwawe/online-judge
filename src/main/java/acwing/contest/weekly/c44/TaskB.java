package acwing.contest.weekly.c44;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    Set<Integer> set = new HashSet<>();
    int base = 1000;
    int x = 105;
    int y = 105;
    set.add(x * base + y);
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    for (int i = 0; i < s.length(); i++) {
      int idx = -1;
      if (s.charAt(i) == 'L') {
        idx = 0;
      } else if (s.charAt(i) == 'R') {
        idx = 1;
      } else if (s.charAt(i) == 'U') {
        idx = 2;
      } else {
        idx = 3;
      }
      x += fs[idx][0];
      y += fs[idx][1];
      set.add(x * base + y);
    }
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{105, 105});
    int[][] d = new int[205][205];
    boolean[][] vis = new boolean[205][205];
    d[105][105] = 0;
    vis[105][105] = true;
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int[] f : fs) {
        int i = f[0] + cur[0];
        int j = f[1] + cur[1];
        if (!set.contains(i * base + j)) {
          continue;
        }
        if (vis[i][j]) {
          continue;
        }
        d[i][j] = d[cur[0]][cur[1]] + 1;
        queue.add(new int[]{i, j});
        vis[i][j] = true;
      }
    }
    if (d[x][y] != s.length()) {
      out.println("NO");
    } else {
      out.println("YES");
    }
  }
}
