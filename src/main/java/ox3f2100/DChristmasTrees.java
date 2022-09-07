package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class DChristmasTrees {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    Queue<Integer> queue = new ArrayDeque<>();
    Map<Integer, Integer> dist = new HashMap<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      queue.add(a[i]);
      dist.put(a[i], 0);
    }
    List<Integer> list = new ArrayList<>();

    long res = 0;
    f:
    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      for (int i = -1; i <= 1; i++) {
        int x = poll + i;
        if (!dist.containsKey(x)) {
          list.add(x);
          queue.add(x);
          res += dist.get(poll) + 1;
          dist.put(x, dist.get(poll) + 1);
        }
        if (list.size() >= m) {
          break f;
        }
      }
    }
    out.println(res);
    for (int i = 0; i < m; i++) {
      out.print(list.get(i), "");
    }
  }
}
