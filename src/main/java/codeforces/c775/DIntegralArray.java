package codeforces.c775;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class DIntegralArray {
  // todo
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int c = in.nextInt();
    Integer[] a = new Integer[n];
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    list = discrete(a);
    list.clear();

    if (list.get(0) != 1) {
      out.println("No");
      return;
    }
    Set<Integer> set = new HashSet<>();
    set.add(1);
    for (int i = 1; i < list.size(); i++) {

      if (!check(list, i, set)) {
        out.println("No");
        return;
      }
      set.add(list.get(i));
    }
    out.println("Yes");
  }

  private boolean check(List<Integer> list, int i, Set<Integer> set) {
    int j = i - 1;
    while (j > 0) {
      int x = list.get(i) / list.get(j);
      if (!set.contains(x)) {
        return false;
      }
      int nj = lowerBound(list, list.get(i) / (x + 1), 0, j);
      if (j == nj) {
        j = nj - 1;
      } else {
        j = nj;
      }
    }
    return true;
  }

  int lowerBound(List<Integer> a, int t, int l, int r) {
    while (l < r) {
      int mid = l + r >> 1;
      if (a.get(mid) >= t) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  List<Integer> discrete(Integer[] a) {
    Arrays.sort(a);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || !a[i].equals(a[i - 1])) {
        list.add(a[i]);
      }
    }
    return list;
  }
}
