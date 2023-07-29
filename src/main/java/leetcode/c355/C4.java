package leetcode.c355;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C4 {
  int n;
  Graph graph;
  long res;
  Map<Integer, Integer> map = new HashMap<>();

  public long countPalindromePaths(List<Integer> parent, String s) {
    n = parent.size();
    graph = new Graph(n, n - 1);

    for (int i = 1; i < n; i++) {
      graph.add(i, parent.get(i), s.charAt(i) - 'a');
    }
    map.put(0, 1);
    dfs(0, 0, 0);
    return res;

  }

  private void dfs(int u, int p, int x) {
    res += map.getOrDefault(x, 0);
    for (int k = 0; k < 26; k++) {
      res += map.getOrDefault(x ^ (1 << k), 0);
    }
    map.put(x, map.getOrDefault(x, 0) + 1);
    for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
      int j = graph.e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u, x ^ (1 << graph.w[i]));
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



