package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B01MST {
  int n, m;


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    DJSet djSet = new DJSet(n + 1);
    Set<Integer>[] sets = new Set[n + 1];
    Arrays.setAll(sets, e -> new HashSet<>());
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      sets[a].add(b);
      sets[b].add(a);
    }

    int[] cnt = new int[n + 1];
    Set<Integer> fa = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      for (Integer integer : fa) {
        cnt[djSet.root(integer)] = 0;
      }
      for (Integer v : sets[i]) {
        if (v < i) {
          cnt[djSet.root(v)]++;
        }
      }
      for (Integer u : fa) {
        int x = djSet.root(u);
        if (-djSet.upper[x] > cnt[x]) {
          djSet.unite(x, i);
        }
      }

      if (djSet.root(i) == i) {
        fa.add(i);
      }
    }

    out.println(djSet.count() - 2);

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