package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.PriorityQueue;

public class EMEXAndIncrements {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    int[] cnt = new int[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      cnt[a[i]]++;
    }
    Arrays.sort(a);
    int j = -1;
    boolean f = false;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
    long p = 0;
    long[] res = new long[n + 1];
    Arrays.fill(res, -1);
    for (int i = 0; i <= n; i++) {
      int last = i - 1;
      if (last >= 0 && cnt[last] == 0) {
        Integer poll = priorityQueue.poll();
        if (poll == null) {
          break;
        } else {
          p += last - poll;
        }
      }
      res[i] = p + cnt[i];
      if (cnt[i] > 0) {
        for (int k = 0; k < cnt[i] - 1; k++) {
          priorityQueue.add(i);
        }
        cnt[i] = 1;
      }
    }
    out.println(res);
  }
}
