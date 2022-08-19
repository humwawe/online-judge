package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class FMaximumWhiteSubtree {
  int N = (int) (2e5 + 5);
  int M = N * 2;
  int[] h = new int[N];
  int[] c = new int[N];
  int[] size = new int[N];
  int[] res = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];

  int idx;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      int x = in.nextInt();
      if (x == 0) {
        c[i] = -1;
      } else {
        c[i] = 1;
      }
    }

    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }

    dfs(1, 1);
    res[1] = size[1];
    dfs2(1, 1);
    for (int i = 1; i <= n; i++) {
      out.print(res[i], "");
    }

  }

  private void dfs2(int u, int p) {
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }

      if (size[j] > 0) {
        res[j] = Math.max(size[j], res[u]);
      } else {
        res[j] = Math.max(size[j], res[u] + size[j]);
      }

      dfs2(j, u);

    }

  }

  private void dfs(int u, int p) {
    size[u] = c[u];
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      if (size[j] > 0) {
        size[u] += size[j];
      }
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
