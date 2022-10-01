package codeforces.g22;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AGloryAddicts {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long sum = 0;
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();

    }
    int[] b = new int[n];
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      b[i] = in.nextInt();
      sum += b[i];
      if (a[i] == 0) {
        list1.add(b[i]);
      } else {
        list2.add(b[i]);
      }
    }
    list1.sort((x, y) -> y - x);
    list2.sort((x, y) -> y - x);
    if (list1.size() == 0 || list2.size() == 0) {
      out.println(sum);
      return;
    }

    out.println(Math.max(helper(list1, list2), helper(list2, list1)));


  }

  private long helper(List<Integer> list1, List<Integer> list2) {
    long res = 0;
    res += list1.get(list1.size() - 1);
    Queue<Integer>[] queues = new Queue[2];

    queues[0] = new ArrayDeque<>();
    queues[1] = new ArrayDeque<>(list2);
    for (int i = 0; i < list1.size() - 1; i++) {
      queues[0].add(list1.get(i));
    }

    int cur = 0;
    while (true) {
      cur = 1 - cur;
      if (!queues[cur].isEmpty()) {
        res += 2 * queues[cur].poll();
      } else {
        cur = 1 - cur;
        if (!queues[cur].isEmpty()) {
          res += queues[cur].poll();
        } else {
          break;
        }
      }
    }
    return res;
  }
}
