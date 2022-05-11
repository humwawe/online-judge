package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DHandshakes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    Queue<Integer>[] queues = new Queue[n + 5];
    for (int i = 0; i <= n; i++) {
      queues[i] = new ArrayDeque<>();
    }

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      queues[a[i]].add(i + 1);
    }
    List<Integer> res = new ArrayList<>();
    int cur = 0;
    while (res.size() < n) {
      if (!queues[cur].isEmpty()) {
        res.add(queues[cur].poll());
        cur++;
      } else {
        if (cur < 3) {
          out.println("Impossible");
          return;
        }
        cur -= 3;
      }
    }
    out.println("Possible");
    out.println(res);
  }
}
