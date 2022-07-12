package codeforces.e131;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DPermutationRestoration {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    P[] range = new P[n];
    for (int i = 1; i <= n; i++) {
      if (a[i] == 0) {
        range[i - 1] = new P(i + 1, n, i - 1);
      } else {
        range[i - 1] = new P(i / (a[i] + 1) + 1, i / a[i], i - 1);
      }
    }

    Arrays.sort(range, Comparator.comparingInt(x -> x.l));

    int[] res = new int[n];

    int j = 0;
    PriorityQueue<P> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.r));

    for (int i = 1; i <= n; i++) {
      while (j < n && range[j].l <= i) {
        priorityQueue.add(range[j]);
        j++;
      }
      P poll = priorityQueue.poll();
      res[poll.id] = i;
    }

    out.println(res);

  }

  class P {
    int l;
    int r;
    int id;

    public P(int l, int r, int id) {
      this.l = l;
      this.r = r;
      this.id = id;
    }
  }
}
