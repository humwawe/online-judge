package codeforces.c796;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ERailwaySystem {
  int n, m;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    int[] a = new int[m];
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < m; i++) {
      set.add(i);
      a[i] = query(in, out, set);
      set.clear();
    }
    Integer[] idx = new Integer[m];
    for (int i = 0; i < m; i++) {
      idx[i] = i;
    }

    Arrays.sort(idx, Comparator.comparingInt(x -> a[x]));

    set.clear();
    set.add(idx[0]);
    int sum = a[idx[0]];
    for (int i = 1; i < m; i++) {
      set.add(idx[i]);
      int x = query(in, out, set);
      if (x == sum + a[idx[i]]) {
        sum += a[idx[i]];
      } else {
        set.remove(idx[i]);
      }
    }

    out.println("!", sum);
    out.flush();
  }

  private int query(InputReader in, OutputWriter out, Set<Integer> set) {
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < m; j++) {
      if (set.contains(j)) {
        sb.append(1);
      } else {
        sb.append(0);
      }
    }
    out.println("?", sb.toString());
    out.flush();
    return in.nextInt();
  }

}
