package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;


public class DRoadsNotOnlyInBerland {
  int[] p;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = i;
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      if (find(a) == find(b)) {
        list.add(a);
        list.add(b);
      }
      p[find(a)] = find(b);
    }
    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (p[i] == i) {
        list2.add(i);
      }
    }
    out.println(list.size() / 2);
    int idx = 0;
    for (int i = 0; i < list.size(); i += 2) {
      out.println(list.get(i) + 1, list.get(i + 1) + 1, list2.get(idx++) + 1, list2.get(idx) + 1);
    }

  }

  int find(int a) {
    if (p[a] == a) {
      return a;
    }
    return p[a] = find(p[a]);
  }
}
