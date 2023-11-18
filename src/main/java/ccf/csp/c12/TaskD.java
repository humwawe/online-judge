package ccf.csp.c12;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    Graph graph = new Graph(n, m * 2);
    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      int a = in.nextInt();
      int b = in.nextInt();
      int c = in.nextInt();
      graph.add(a, b, c, t);
    }

    PriorityQueue<int[]> pr = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));

    pr.add(new int[]{1, 0, 0});
    boolean[][] vis = new boolean[n + 1][1005];
    int[][] dist = new int[n + 1][1005];
    int inf = (int) 1e8;
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dist[i], inf);
    }

    dist[1][0] = 0;
    while (!pr.isEmpty()) {
      int[] poll = pr.poll();
      int u = poll[0];
      int d = poll[1];
      int t = poll[2];
      if (vis[u][d]) {
        continue;
      }
      vis[u][d] = true;

      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (graph.t[i] == 1) {
          int curV = dist[u][d] + graph.w[i] * graph.w[i] + 2 * d * graph.w[i];
          if (d + graph.w[i] < 1005 && dist[j][d + graph.w[i]] > curV) {
            dist[j][d + graph.w[i]] = curV;
            pr.add(new int[]{j, d + graph.w[i], curV});
          }

        } else {
          int curV = dist[u][d] + graph.w[i];
          if (dist[j][0] > curV) {
            dist[j][0] = curV;
            pr.add(new int[]{j, 0, curV});
          }
        }
      }
    }
    int res = inf;
    for (int i = 0; i < 1005; i++) {
      res = Math.min(res, dist[n][i]);
    }
    out.println(res);
  }

  class Graph {
    public int N, M;
    public int[] h;
    public int[] e;
    public int[] ne;
    public int[] w;
    public int[] t;
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
      w = new int[M];
      t = new int[M];
      idx = 0;
      Arrays.fill(h, -1);

      fe = new int[M];
    }

    public void add(int a, int b, int c, int d) {
      add0(a, b, c, d);
      if (!flag) {
        add0(b, a, c, d);
      }
    }


    private void add0(int a, int b, int c, int d) {
      fe[idx] = a;
      e[idx] = b;
      w[idx] = c;
      t[idx] = d;
      ne[idx] = h[a];
      h[a] = idx++;
    }

  }

}
