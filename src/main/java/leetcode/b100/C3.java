package leetcode.b100;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C3 {
  public long findScore(int[] nums) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
      int d = x[0] - y[0];
      if (d == 0) {
        return x[1] - y[1];
      }
      return d;
    });

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      priorityQueue.add(new int[]{nums[i], i});
    }

    boolean[] vis = new boolean[n];

    long res = 0;
    while (!priorityQueue.isEmpty()) {
      int[] poll = priorityQueue.poll();
      int x = poll[0];
      int i = poll[1];
      if (vis[i]) {
        continue;
      }
      res += x;
      vis[i] = true;
      if (i - 1 >= 0) {
        vis[i - 1] = true;
      }
      if (i + 1 < n) {
        vis[i + 1] = true;
      }
    }
    return res;
  }
}
