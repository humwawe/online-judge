package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.Queue;

public class BTwoHeaps {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt() * 2;
    int[] a = new int[n];
    Queue<Integer>[] queues = new Queue[105];
    for (int i = 0; i < queues.length; i++) {
      queues[i] = new ArrayDeque<>();
    }
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      queues[a[i]].add(i);
    }
    int last = 2;
    int[] res = new int[n];
    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 10; i < 105; i++) {
      if (queues[i].isEmpty()) {
        continue;
      }
      if (queues[i].size() >= 2) {
        res[queues[i].poll()] = 1;
        res[queues[i].poll()] = 2;
        cnt1++;
        cnt2++;
      } else if (queues[i].size() == 1) {
        res[queues[i].poll()] = 3 - last;
        if (3 - last == 1) {
          cnt1++;
        } else {
          cnt2++;
        }
        last = 3 - last;
      }
    }
    out.println(cnt1 * cnt2);

    for (int i = 0; i < n; i++) {
      if (res[i] == 0) {
        if (cnt1 < n / 2) {
          res[i] = 1;
          cnt1++;
        } else {
          res[i] = 2;
          cnt2++;
        }
      }
    }
    out.println(res);
  }
}
