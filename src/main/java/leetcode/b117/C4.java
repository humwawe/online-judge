package leetcode.b117;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C4 {
  public long maxSpending(int[][] values) {
    int n = values.length;
    int m = values[0].length;
    for (int i = 0; i < n; i++) {
      Arrays.sort(values[i]);
    }
    long res = 0;
    int[] idx = new int[n];
    PriorityQueue<int[]> pr = new PriorityQueue<>((x, y) -> x[0] - y[0]);
    for (int i = 0; i < n; i++) {
      pr.add(new int[]{values[i][idx[i]++], i});
    }
    for (long i = 1; i <= n * m; i++) {
      int[] poll = pr.poll();
      int cur = poll[1];
      res += i * poll[0];
      if (idx[cur] < m) {
        pr.add(new int[]{values[cur][idx[cur]++], cur});
      }
    }
    return res;
  }
}
