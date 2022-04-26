package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BChemicalTable {
  int[] p;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int q = in.nextInt();
    p = new int[n + m + 1];
    for (int i = 1; i <= n + m; i++) {
      p[i] = i;
    }
    for (int i = 0; i < q; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      union(a, b + n);
    }
    int res = 0;
    for (int i = 1; i <= n + m; i++) {
      if (find(i) == i) {
        res++;
      }
    }
    out.println(res - 1);
  }

  int find(int x) {
    if (p[x] != x) {
      p[x] = find(p[x]);
    }
    return p[x];
  }

  void union(int a, int b) {
    if (find(a) == find(b)) {
      return;
    }
    p[find(a)] = find(b);
  }
}
