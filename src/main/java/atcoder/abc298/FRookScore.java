package atcoder.abc298;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class FRookScore {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<Integer, Long> xs = new HashMap<>();
    Map<Integer, Long> ys = new HashMap<>();
    int[] x = new int[n];
    int[] y = new int[n];
    long[] v = new long[n];
    Map<Integer, Set<Integer>> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      x[i] = in.nextInt();
      y[i] = in.nextInt();
      v[i] = in.nextLong();
      mp.computeIfAbsent(x[i], key -> new HashSet<>()).add(i);
      xs.merge(x[i], v[i], Long::sum);
      ys.merge(y[i], v[i], Long::sum);
    }
    PrioritySet<Long> prioritySet = new PrioritySet<>((a, b) -> Long.compare(b, a));

    for (Long value : ys.values()) {
      prioritySet.add(value);
    }

    long res = 0;

    for (Map.Entry<Integer, Set<Integer>> entry : mp.entrySet()) {
      int xv = entry.getKey();
      Set<Integer> idx = entry.getValue();
      for (Integer integer : idx) {
        prioritySet.erase(ys.get(y[integer]));
        prioritySet.add(ys.get(y[integer]) - v[integer]);
      }

      res = Math.max(res, xs.get(xv) + prioritySet.peek());

      for (Integer integer : idx) {
        prioritySet.add(ys.get(y[integer]));
        prioritySet.erase(ys.get(y[integer]) - v[integer]);
      }
    }
    out.println(res);
  }


  class PrioritySet<T> {
    PriorityQueue<T> base, deleted;

    public PrioritySet(Comparator<? super T> comparator) {
      base = new PriorityQueue<>(comparator);
      deleted = new PriorityQueue<>(comparator);
    }

    public PrioritySet() {
      base = new PriorityQueue<>();
      deleted = new PriorityQueue<>();
    }

    void add(T x) {
      base.add(x);
    }

    void erase(T x) {
      deleted.add(x);
    }

    T peek() {
      while (!deleted.isEmpty() && deleted.peek().equals(base.peek())) {
        base.poll();
        deleted.poll();
      }
      return base.peek();
    }

    T poll() {
      while (!deleted.isEmpty() && deleted.peek().equals(base.peek())) {
        base.poll();
        deleted.poll();
      }
      return base.poll();
    }

  }

}
