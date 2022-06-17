package codeforces.c800;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DFakePlasticTrees {
  int[] h, e, ne;
  int idx;
  int n;
  long[] l, r;
  int[] ans;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int N = n + 5;
    int M = N * 2;
    h = new int[N];
    e = new int[M];
    ne = new int[M];
    Arrays.fill(h, -1);
    idx = 0;

    l = new long[n + 1];
    r = new long[n + 1];
    ans = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      int a = in.nextInt();
      add(a, i);
      add(i, a);
    }

    for (int i = 1; i <= n; i++) {
      l[i] = in.nextInt();
      r[i] = in.nextInt();
    }

    dfs(1, 1);

    out.println(ans[1]);
  }

  private void dfs(int u, int p) {
    long allR = 0;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      allR += r[j];
      ans[u] += ans[j];
    }
    if (l[u] > allR) {
      ans[u]++;
    } else {
      r[u] = Math.min(r[u], allR);
    }

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
