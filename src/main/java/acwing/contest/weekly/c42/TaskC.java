package acwing.contest.weekly.c42;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  int N = (int) 3e5;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int[] w = new int[M];

  int idx;
  int n;
  int[] d = new int[N];
  int res = 0;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Arrays.fill(h, -1);
    idx = 0;
    n = in.nextInt();
    int lim = (1 << (n + 1)) - 1;
    for (int i = 2; i <= lim; i++) {
      int x = in.nextInt();
      add(i / 2, i, x);
    }
    dfs(1);
    out.println(res);
  }

  void dfs(int u) {
    int[] tmp = new int[2];
    int idx = 0;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      dfs(j);
      d[u] = Math.max(d[u], d[j] + w[i]);
      tmp[idx++] = d[j] + w[i];
    }
    res += Math.abs(tmp[0] - tmp[1]);
  }

  void add(int a, int b, int c) {
    e[idx] = b;
    w[idx] = c;
    ne[idx] = h[a];
    h[a] = idx++;
  }

}
