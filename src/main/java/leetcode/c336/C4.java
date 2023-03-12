package leetcode.c336;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {

  public int findMinimumTime(int[][] tasks) {

    int n = tasks.length;
    Arrays.sort(tasks, (x, y) -> x[1] - y[1]);
    boolean[] vis = new boolean[2005];
    int res = 0;
    for (int i = 0; i < n; i++) {
      int l = tasks[i][0];
      int r = tasks[i][1];
      int d = tasks[i][2];
      int cnt = 0;
      for (int j = l; j <= r; j++) {
        if (vis[j]) {
          cnt++;
        }
      }

      if (cnt >= d) {
        continue;
      }
      d -= cnt;
      for (int j = r; j > l - 1; j--) {
        if (!vis[j]) {
          vis[j] = true;
          res++;
          d--;
        }
        if (d == 0) {
          break;
        }
      }
    }
    return res;
  }
}
