package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class CF1136DNastyaIsBuyingLunch {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    Set<Integer>[] sets = new Set[n + 1];
    for (int i = 1; i <= n; i++) {
      sets[i] = new HashSet<>();
    }
    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      sets[x].add(y);
    }


    Set<Integer> set = new HashSet<>();
    set.add(a[n - 1]);

    for (int i = n - 1; i >= 1; i--) {
      if (!sets[a[i - 1]].containsAll(set)) {
        set.add(a[i - 1]);
      }
    }

    out.println(n - set.size());


  }
}
