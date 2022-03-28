package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTheNumberOfImposters {
  int[] p;
  int[] size;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    p = new int[2 * n + 1];
    size = new int[2 * n + 1];
    for (int i = 0; i <= 2 * n; i++) {
      p[i] = i;
      if (i <= n) {
        size[i] = 1;
      }
    }

    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      String s = in.nextString();
      if (s.charAt(0) == 'i') {
        union(b + n, a);
        union(a + n, b);
      } else {
        union(a, b);
        union(a + n, b + n);
      }
    }
    int res = 0;
    for (int i = 1; i <= n; i++) {
      if (find(i) == find(i + n)) {
        out.println(-1);
        return;
      }
      res += Math.max(size[find(i)], size[find(i + n)]);
      size[find(i)] = 0;
      size[find(i + n)] = 0;
    }
    out.println(res);
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
    size[find(b)] += size[find(a)];
    p[find(a)] = find(b);
  }
}
