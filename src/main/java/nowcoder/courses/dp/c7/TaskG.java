package nowcoder.courses.dp.c7;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskG {
  Graph graph;
  int[] size;
  long[] ans, flow;
  int n;
  boolean[] isLeaf;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    size = new int[n];
    flow = new long[n];
    ans = new long[n];
    isLeaf = new boolean[n];
    graph = new Graph(n, n - 1);
    for (int i = 0; i < n - 1; i++) {
      int a = in.nextInt() - 1;
      int b = in.nextInt() - 1;
      int c = in.nextInt();
      graph.add(a, b, c);
    }
    long inf = (long) 1e15;

    dfs(0, 0);
    ans[0] = flow[0];

    dfs2(0, 0);
    long res = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, ans[i]);
    }
    out.println(res);
  }

  private void dfs(int u, int p) {
    size[u] = 1;
    isLeaf[u] = true;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }

      dfs(j, u);
      size[u] += size[j];
      isLeaf[u] = false;
      if (isLeaf[j]) {
        flow[u] += graph.w[i];
      } else {
        flow[u] += Math.min(flow[j], graph.w[i]);
      }

    }

  }

  private void dfs2(int u, int p) {
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      if (ans[u] - graph.w[i] == 0) {
        ans[j] = flow[j] + graph.w[i];
      } else {
        ans[j] = flow[j] + Math.min(graph.w[i], (ans[u] - Math.min(flow[j], graph.w[i])));
      }

      dfs2(j, u);
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
