package codeforces.c738;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class D1MochaAndDianaEasyVersion {

  int[] p1 = new int[1005];
  int[] p2 = new int[1005];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m1 = in.nextInt();
    int m2 = in.nextInt();
    for (int i = 1; i <= n; i++) {
      p1[i] = i;
      p2[i] = i;
    }
    for (int i = 0; i < m1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      union(p1, a, b);
    }
    for (int i = 0; i < m2; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      union(p2, a, b);
    }
    List<int[]> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (find(p1, i) == find(p1, j) || find(p2, i) == find(p2, j)) {
          continue;
        }
        list.add(new int[]{i, j});
        union(p1, i, j);
        union(p2, i, j);
      }
    }
    out.println(list.size());
    for (int[] ps : list) {
      out.println(ps[0] + " " + ps[1]);
    }
  }

  int find(int[] p, int x) {
    if (p[x] != x) {
      p[x] = find(p, p[x]);
    }
    return p[x];
  }

  void union(int[] p, int a, int b) {
    if (find(p, a) == find(p, b)) {
      return;
    }
    p[find(p, a)] = find(p, b);
  }
}
