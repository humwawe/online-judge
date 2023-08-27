package leetcode.c360;

import java.util.List;

/**
 * @author hum
 */
public class C4 {
  public long getMaxFunctionValue(List<Integer> receiver, long k) {
    int n = receiver.size();
    int[][] pa = new int[n][36];
    long[][] dis = new long[n][36];
    for (int i = 0; i < n; i++) {
      pa[i][0] = receiver.get(i);
      dis[i][0] = receiver.get(i);
    }

    for (int i = 1; i < 36; i++) {
      for (int j = 0; j < n; j++) {
        pa[j][i] = pa[pa[j][i - 1]][i - 1];
        dis[j][i] = dis[j][i - 1] + dis[pa[j][i - 1]][i - 1];
      }
    }

    long res = 0;
    for (int i = 0; i < n; i++) {
      long cur = i;
      int x = i;
      for (int j = 0; j < 36; j++) {
        if ((k >> j & 1) == 1) {
          cur += dis[x][j];
          x = pa[x][j];
        }
      }
      res = Math.max(res, cur);
    }
    return res;
  }
}
