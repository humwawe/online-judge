package acwing.contest.weekly.c75;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  int N = 50005;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] par = new int[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int r1 = in.nextInt();
    int r2 = in.nextInt();
    Arrays.fill(h, -1);
    idx = 0;
    for (int i = 1; i <= n; i++) {
      if (i == r1) {
        continue;
      }
      int p = in.nextInt();
      add(i, p);
      add(p, i);
    }

    dfs(r2, r2);
    for (int i = 1; i <= n; i++) {
      if (i == r2) {
        continue;
      }
      out.print(par[i], "");
    }
    out.println();

  }

  private void dfs(int u, int p) {
    par[u] = p;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
    }
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
