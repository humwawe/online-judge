package codeforces.c766;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CNotAssigning {
  int N = 100010;
  int M = N * 2;
  int[] h;
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] dep;
  int[] res;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    h = new int[n + 1];
    dep = new int[n + 1];
    res = new int[n - 1];
    Arrays.fill(h, -1);
    idx = 0;
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      add(a, b);
      add(b, a);
      dep[a]++;
      dep[b]++;
    }
    int start = 0;
    for (int i = 1; i <= n; i++) {
      if (dep[i] > 2) {
        out.println(-1);
        return;
      }
      if (dep[i] == 1) {
        start = i;
      }
    }
    dfs(start, start, 2);
    out.println(res);
  }

  private void dfs(int u, int p, int num) {
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      res[i / 2] = num;
      dfs(j, u, 7 - num);
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
