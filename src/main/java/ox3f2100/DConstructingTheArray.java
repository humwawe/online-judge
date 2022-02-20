package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class DConstructingTheArray {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> {
      int t1 = x[1] - x[0];
      int t2 = y[1] - y[0];
      if (t1 == t2) {
        return x[0] - y[0];
      }
      return t2 - t1;
    });
    priorityQueue.add(new int[]{1, n});
    int[] res = new int[n + 1];
    int idx = 0;
    while (!priorityQueue.isEmpty()) {
      idx++;
      int[] cur = priorityQueue.poll();
      int x = cur[0];
      int y = cur[1];
      int mid = x + y >> 1;
      res[mid] = idx;
      if (mid - 1 >= x) {
        priorityQueue.add(new int[]{x, mid - 1});
      }
      if (y >= mid + 1) {
        priorityQueue.add(new int[]{mid + 1, y});
      }
    }
    for (int i = 1; i <= n; i++) {
      out.print(res[i] + " ");
    }
    out.println();
  }
}
