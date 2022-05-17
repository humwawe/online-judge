package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class GPrivatizationOfRoadsInTreeland {
  int N = 200010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, k;
  int[] deg;
  int res;
  int[] ans = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    k = in.nextInt();
    deg = new int[n];
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      add(a, b);
      add(b, a);
      deg[a]++;
      deg[b]++;
    }

    Arrays.sort(deg);
    res = deg[n - k - 1];
    out.println(res);
    dfs(0, 0, 0);
    for (int i = 0; i < n - 1; i++) {
      out.print(ans[i] + 1, "");
    }

  }

  private void dfs(int u, int p, int c) {
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      c++;
      ans[i / 2] = c % res;
      dfs(j, u, c);
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
