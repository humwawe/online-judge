package acwing.contest.weekly.c1;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  int N = (int) (2e5 + 5);
  int[] p = new int[N + 1];
  int[] size = new int[N + 1];
  int[] a = new int[N];

  // 找环也可以直接dfs
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();

    for (int i = 1; i <= n; i++) {
      p[i] = i;
      size[i] = 1;
      a[i] = in.nextInt();
    }
    for (int i = 1; i <= n; i++) {
      union(a[i], a[a[i]]);
    }
    for (int i = 1; i <= n; i++) {
      out.print(size[find(i)] + " ");
    }
    out.println();
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
