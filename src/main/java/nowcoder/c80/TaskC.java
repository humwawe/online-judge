package nowcoder.c80;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    int[] a = in.nextInt(n);
    int[] cnt = new int[m];
    for (int i : a) {
      cnt[i - 1]++;
    }
    int[] res = new int[m];

    for (int i = 0; i < m; i++) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
      for (int j = 0; j < m; j++) {
        if (j == i) {
          continue;
        }
        priorityQueue.add(cnt[j]);
      }
      if (n - cnt[i] < k) {
        res[i] = -1;
        continue;
      }

      int t = k;

      while (!priorityQueue.isEmpty() && t > 0) {
        Integer poll = priorityQueue.poll();
        priorityQueue.add(poll - 1);
        t--;
      }
      res[i] = priorityQueue.peek();
    }
    out.println(res);

  }
}
