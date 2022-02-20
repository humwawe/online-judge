package acwing.contest.weekly.c36;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskB {
  int N = 105;
  int M = N * N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n, m;
  boolean[] vis = new boolean[N];

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
    if (n != m) {
      out.println("NO");
      return;
    }
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (!vis[i]) {
        cnt++;
        dfs(i);
      }
    }
    if (cnt != 1) {
      out.println("NO");
      return;
    }
    out.println("YES");

  }

  void dfs(int u) {
    vis[u] = true;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (!vis[j]) {
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
