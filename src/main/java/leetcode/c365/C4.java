package leetcode.c365;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class C4 {
  Graph graph;
  int[] cn, size, res;

  public int[] countVisitedNodes(List<Integer> edges) {
    int n = edges.size();
    graph = new Graph(n, n, true);
    int[] du = new int[n];
    for (int i = 0; i < n; i++) {
      graph.add(i, edges.get(i));
      du[edges.get(i)]++;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (du[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        du[j]--;
        if (du[j] == 0) {
          queue.add(j);
        }
      }
    }
    int c = 1;
    cn = new int[n];
    size = new int[n + 1];
    for (int i = 0; i < n; i++) {
      if (du[i] == 0) {
        continue;
      }
      dfs(i, c++);
    }


    res = new int[n];
    for (int i = 0; i < n; i++) {
      dfs2(i);
    }
    return res;
  }

  private void dfs2(int u) {
    if (cn[u] != 0) {
      res[u] = size[cn[u]];
      return;
    }
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      dfs2(j);
      res[u] = res[j] + 1;
    }
  }

  private void dfs(int u, int num) {
    if (cn[u] != 0) {
      return;
    }
    cn[u] = num;
    size[num]++;
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      dfs(j, num);
    }
  }

  class Graph {
    public int N, M;
    public int[] h;
    public int[] e;
    public int[] ne;
    public int[] w;
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

    public void add(int a, int b, int c) {
      add0(a, b, c);
      if (!flag) {
        add0(b, a, c);
      }
    }

    private void add0(int a, int b) {
      add0(a, b, 0);
    }

    private void add0(int a, int b, int c) {
      fe[idx] = a;
      e[idx] = b;
      w[idx] = c;
      ne[idx] = h[a];
      h[a] = idx++;
    }
  }
}
