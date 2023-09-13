package leetcode.c362;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author hum
 */
public class C3 {
  int[] base = new int[]{(int) 1e8, (int) 1e7, (int) 1e6, (int) 1e5, (int) 1e4, (int) 1e3, (int) 1e2, (int) 1e1, 1};

  public int minimumMoves(int[][] grid) {
    Queue<Integer> queue = new ArrayDeque<>();
    int cur = helper(grid);
    queue.add(cur);
    Map<Integer, Integer> map = new HashMap<>();
    map.put(cur, 0);
    int[][] fs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    while (!queue.isEmpty()) {
      int st = queue.poll();
      int[][] tmp = rev(st);
      int[][] ntmp = tmp.clone();
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (tmp[i][j] == 1) {
            continue;
          }

          if (tmp[i][j] > 1) {
            for (int[] f : fs) {
              int x = i + f[0];
              int y = j + f[1];
              if (x >= 0 && x < 3 && y >= 0 && y < 3) {
                ntmp[x][y]++;
                ntmp[i][j]--;
                int now = helper(ntmp);
                if (!map.containsKey(now)) {
                  queue.add(now);
                  map.put(now, map.get(st) + 1);
                }
                ntmp[x][y]--;
                ntmp[i][j]++;
              }
            }
          }
        }
      }
    }
    return map.get(111111111);

  }

  private int[][] rev(int st) {
    int[][] res = new int[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        res[2 - i][2 - j] = st % 10;
        st /= 10;
      }
    }
    return res;
  }

  private int helper(int[][] grid) {
    int st = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        st += grid[i][j] * base[i * 3 + j];
      }
    }
    return st;
  }
}
