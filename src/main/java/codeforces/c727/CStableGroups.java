package codeforces.c727;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CStableGroups {
  int n;
  long k, x;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextLong();
    x = in.nextLong();
    List<Long> a = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      a.add(in.nextLong());
    }
    Collections.sort(a);
    List<Long> need = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      long tmp = a.get(i) - a.get(i - 1);
      if (tmp > x) {
        need.add((tmp - 1) / x);
      }
    }
    int res = need.size() + 1;
    Collections.sort(need);
    for (Long l : need) {
      if (l <= k) {
        res--;
        k -= l;
      } else {
        break;
      }
    }
    out.println(res);
  }
}
