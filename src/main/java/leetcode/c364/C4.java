package leetcode.c364;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {

  public long countPaths(int n, int[][] edges) {
    int[] primes = new int[n + 1];
    boolean[] vis = new boolean[n + 1];
    vis[1] = true;
    int cnt = 0;
    for (int i = 2; i <= n; i++) {
      if (vis[i]) {
        continue;
      }
      primes[cnt++] = i;
      for (int j = i; j <= n / i; j++) {
        vis[i * j] = true;
      }
    }

    Graph graph = new Graph(n + 1, n - 1);
    DJSet djSet = new DJSet(n + 1);
    for (int[] edge : edges) {
      graph.add(edge[0], edge[1]);
      if (vis[edge[0]] && vis[edge[1]]) {
        djSet.unite(edge[0], edge[1]);
      }
    }
    long res = 0;
    for (int c = 0; c < cnt; c++) {
      int u = primes[c];
      long size = 0;
      for (int i = graph.h[u]; i != -1; i = graph.ne[i]) {
        int j = graph.e[i];
        if (!vis[j]) {
          continue;
        }
        long cur = djSet.size(j);
        res += size * cur;
        size += cur;
      }
      res += size;
    }
    return res;

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

  class DJSet {
    // 负数表示集合的大小，正数表示属于这个集合的代表元素
    public int[] upper;
    private final int[] prev;

    public DJSet(int n) {
      upper = new int[n];
      prev = new int[n];
      for (int i = 0; i < n; i++) {
        upper[i] = -1;
        prev[i] = i - 1;
      }
    }

    public int root(int x) {
      return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
    }

    public boolean equiv(int x, int y) {
      return root(x) == root(y);
    }

    public boolean unite(int x, int y) {
      x = root(x);
      y = root(y);
      // 按集合大小合并，否则优先合并到x
      if (x != y) {
        if (upper[y] < upper[x]) {
          int d = x;
          x = y;
          y = d;
        }
        upper[x] += upper[y];
        upper[y] = x;
      }
      return x == y;
    }

    // 查询[l,r] 是否在同一个集合
    boolean query(int l, int r) {
      assert l <= r;
      int root = root(r);
      int rr = r;
      while (0 <= rr && root(rr) == root) {
        rr = prev[rr];
      }
      int i = r;
      while (0 <= i && root(i) == root) {
        int temp = prev[i];
        prev[i] = rr;
        i = temp;
      }
      return rr < l;
    }

    // 集合个数
    public int count() {
      int ct = 0;
      for (int u : upper) {
        if (u < 0) {
          ct++;
        }
      }
      return ct;
    }

    public int size(int x) {
      return -upper[root(x)];
    }

    public int[][] toBucket() {
      int n = upper.length;
      int[][] ret = new int[n][];
      int[] rp = new int[n];
      for (int i = 0; i < n; i++) {
        if (upper[i] < 0) {
          ret[i] = new int[-upper[i]];
        }
      }
      for (int i = 0; i < n; i++) {
        int r = root(i);
        ret[r][rp[r]++] = i;
      }
      return ret;
    }
  }
}
