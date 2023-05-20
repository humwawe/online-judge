package atcoder.abc302;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EIsolation {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int q = in.nextInt();
    Set<Integer>[] sets = new Set[n];
    Arrays.setAll(sets, e -> new HashSet<>());
    int[] deg = new int[n];
    int res = n;
    for (int i = 0; i < q; i++) {
      int t = in.nextInt();
      if (t == 1) {
        int u = in.nextInt() - 1;
        int v = in.nextInt() - 1;
        sets[u].add(v);
        sets[v].add(u);
        deg[u]++;
        deg[v]++;
        if (deg[u] == 1) {
          res--;
        }
        if (deg[v] == 1) {
          res--;
        }
      } else {
        int v = in.nextInt() - 1;

        for (Integer u : sets[v]) {
          sets[u].remove(v);
          deg[u]--;
          if (deg[u] == 0) {
            res++;
          }
        }
        if (deg[v] > 0) {
          res++;
        }
        sets[v].clear();
        deg[v] = 0;
      }

      out.println(res);
    }
  }
}
