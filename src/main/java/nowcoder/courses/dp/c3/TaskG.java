package nowcoder.courses.dp.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskG {
  int n, m, s;
  Graph graph;
  long[] v;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    s = in.nextInt();
    v = new long[n + 1];
    Arrays.fill(v, (long) 1e18);
    graph = new Graph(n, m);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      long c = in.nextInt();
      graph.add(a, b, c);
    }

    dfs(s, s);
    out.println(v[s]);
  }

  private void dfs(int u, int p) {
    boolean f = false;
    long tmp = 0;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      f = true;
      tmp += Math.min(v[j], graph.w[i]);
    }
    if (f) {
      v[u] = Math.min(tmp, v[u]);
    }
  }

  class Graph {
    public int N, M;
    public int[] h;
    public int[] e;
    public int[] ne;
    public long[] w;
    int idx, n, m;
    // 是否有方向，默认无向边
    boolean flag;
    // 第i条边的from节点，e存的是to的节点
    public int[] fe;

    public Graph(int n, int m) {
      this(n, m, false);
    }

    public Graph(int n, int m, boolean f) {
      this.n = n;
      this.m = m;
      flag = f;
      N = n + 5;
      M = flag ? m + 5 : m * 2 + 5;

      h = new int[N];
      e = new int[M];
      ne = new int[M];
      w = new long[M];
      idx = 0;
      Arrays.fill(h, -1);

      fe = new int[M];
    }

    public void add(int a, int b) {
      add0(a, b);
      if (!flag) {
        add0(b, a);
      }
    }

    public void add(int a, int b, long c) {
      add0(a, b, c);
      if (!flag) {
        add0(b, a, c);
      }
    }

    private void add0(int a, int b) {
      add0(a, b, 0);
    }

    private void add0(int a, int b, long c) {
      fe[idx] = a;
      e[idx] = b;
      w[idx] = c;
      ne[idx] = h[a];
      h[a] = idx++;
    }

  }
}