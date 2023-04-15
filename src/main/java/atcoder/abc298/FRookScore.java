package atcoder.abc298;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class FRookScore {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    Map<Long, Long> xs = new HashMap<>();
    Map<Long, Long> ys = new HashMap<>();
    long[] x = new long[n];
    long[] y = new long[n];
    long[] v = new long[n];
    Map<Long, Set<Long>> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      x[i] = in.nextLong();
      y[i] = in.nextLong();
      v[i] = in.nextLong();
      mp.computeIfAbsent(x[i], key -> new HashSet<>()).add(y[i]);
      xs.merge(x[i], v[i], Long::sum);
      ys.merge(y[i], v[i], Long::sum);
    }
    List<Nod> list = new ArrayList<>();
    for (Map.Entry<Long, Long> entry : ys.entrySet()) {
      list.add(new Nod(entry.getKey(), entry.getValue()));
    }
    list.sort(Comparator.comparingLong(p -> -p.v));
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, xs.get(x[i]) + ys.get(y[i]) - v[i]);
    }
    for (Map.Entry<Long, Set<Long>> entry : mp.entrySet()) {
      long xv = entry.getKey();
      for (Nod p : list) {
        if (entry.getValue().contains(p.c)) {
          continue;
        }
        ans = Math.max(ans, xs.get(xv) + p.v);
        break;
      }
    }
    out.println(ans);
  }

  class Nod {
    long c;
    long v;

    public Nod(long c, long v) {
      this.c = c;
      this.v = v;
    }
  }

}
