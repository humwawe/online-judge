package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ARecommendations {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    P[] a = new P[n];

    for (int i = 0; i < n; i++) {
      a[i] = new P(in.nextInt(), -1);
    }
    for (int i = 0; i < n; i++) {
      a[i].t = in.nextInt();
    }

    Arrays.sort(a, Comparator.comparingInt(x -> x.v));

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);

    long sum = 0;
    long res = 0;
    int cur = -1;
    for (int i = 0; i < n || !priorityQueue.isEmpty(); ) {
      if (priorityQueue.isEmpty()) {
        cur = a[i].v;
      }
      while (i < n && a[i].v == cur) {
        priorityQueue.add(a[i].t);
        sum += a[i].t;
        i++;
      }

      sum -= priorityQueue.poll();
      res += sum;
      cur++;
    }
    out.println(res);

  }

  class P {
    int v;
    int t;

    public P(int v, int t) {
      this.v = v;
      this.t = t;
    }


  }
}
