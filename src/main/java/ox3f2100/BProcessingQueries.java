package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Deque;

public class BProcessingQueries {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int b = in.nextInt();
    long[] t = new long[n];
    long[] d = new long[n];
    for (int i = 0; i < n; i++) {
      t[i] = in.nextInt();
      d[i] = in.nextInt();
    }
    long[] res = new long[n];
    Deque<Long> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      while (!queue.isEmpty() && queue.peekFirst() <= t[i]) {
        queue.pollFirst();
      }
      if (queue.size() == b + 1) {
        res[i] = -1;
        continue;
      }
      long end = (queue.isEmpty() ? t[i] : queue.peekLast()) + d[i];
      queue.add(end);
      res[i] = end;
    }
    out.println(res);
  }
}
