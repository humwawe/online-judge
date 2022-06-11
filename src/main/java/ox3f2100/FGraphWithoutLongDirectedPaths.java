package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class FGraphWithoutLongDirectedPaths {
  int N = 200010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, m;
  int[] color = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    m = in.nextInt();
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
    }
    color[1] = 1;
    dfs(1);
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < idx; i += 2) {
      int b = e[i];
      int a = e[i ^ 1];
      if (color[a] == color[b]) {
        out.println("NO");
        return;
      }
      if (color[a] == 1) {
        res.append(0);
      } else {
        res.append(1);
      }
    }
    out.println("YES");
    out.println(res);
  }

  private void dfs(int u) {
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (color[j] == 0) {
        color[j] = 3 - color[u];
        dfs(j);
      }
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
