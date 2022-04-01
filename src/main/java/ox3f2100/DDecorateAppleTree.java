package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DDecorateAppleTree {
  int N = 100010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] size = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    int n = in.nextInt();
    for (int i = 2; i <= n; i++) {
      int a = in.nextInt();
      add(i, a);
      add(a, i);
    }
    dfs(1, 1);
    Arrays.sort(size, 1, n + 1);
    for (int i = 1; i <= n; i++) {
      out.print(size[i], "");
    }
    out.println();
  }

  private void dfs(int u, int p) {
    boolean leaf = true;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      leaf = false;
      dfs(j, u);
      size[u] += size[j];
    }
    if (leaf) {
      size[u] = 1;
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
