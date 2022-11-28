package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskG {


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    SegmentTree3 segmentTree3 = new SegmentTree3(n);
    for (int i = 0; i < m; i++) {
      int q = in.nextInt();
      int l = in.nextInt();
      int r = in.nextInt();
      if (q == 1) {
        segmentTree3.add(1, l, r, l - 1);
      } else {
        out.println(segmentTree3.query(1, l, r));
      }
    }
  }


  class SegmentTree3 {
    int N;
    int[] left;
    int[] right;
    long[] sum;
    long[][] lazy;
    long[][] base;
    int[] w;
    long inv6 = 166666668;
    int mod = (int) (1e9 + 7);

    public SegmentTree3(int n) {
      N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      sum = new long[N * 4];
      lazy = new long[N * 4][3];
      base = new long[N * 4][2];
      w = new int[n];
      build(1, 1, n);
    }

    void pushUp(int u) {
      pushDown(u << 1);
      pushDown(u << 1 | 1);
      sum[u] = (sum[u << 1] + sum[u << 1 | 1]) % mod;
      for (int i = 0; i < 2; i++) {
        base[u][i] = (base[u << 1][i] + base[u << 1 | 1][i]) % mod;
      }

    }

    void pushDown(int u) {
      // 有tag
      if (lazy[u][0] != 0 || lazy[u][1] != 0 || lazy[u][2] != 0) {
        // calLazy(u): 计算当前tag的当前层的影响
        sum[u] = (sum[u] + (right[u] - left[u] + 1) * lazy[u][2] % mod
            + (lazy[u][0] * base[u][0] % mod)
            + (lazy[u][1] * base[u][1] % mod)) % mod;
        if (left[u] != right[u]) {
          for (int i = 0; i < 3; i++) {
            lazy[u << 1][i] += lazy[u][i];
            lazy[u << 1 | 1][i] += lazy[u][i];
            lazy[u << 1][i] %= mod;
            lazy[u << 1 | 1][i] %= mod;
          }
        }
        // initLazy(u): tag恢复
        for (int i = 0; i < 3; i++) {
          lazy[u][i] = 0;
        }
      }
    }

    // 从u开始，构建[l,r]的树，w[i]存每个节点的值(从l到r)
    void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        sum[u] = 0;
        base[u][0] = (long) l * l % mod;
        base[u][1] = l % mod;
        return;
      }

      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    // 从u开始查找
    long query(int u, int l, int r) {
      pushDown(u);

      if (left[u] == l && right[u] == r) {
        return sum[u];
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return (query(u << 1, l, mid) + query(u << 1 | 1, mid + 1, r)) % mod;
      }

    }

    void add(int u, int l, int r, long d) {
      pushDown(u);

      if (left[u] == l && right[u] == r) {
        lazy[u][0] = 1;
        lazy[u][1] = (mod - 2 * d % mod) % mod;
        lazy[u][2] = d * d % mod;
        return;
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        add(u << 1, l, r, d);
      } else if (l > mid) {
        add(u << 1 | 1, l, r, d);
      } else {
        add(u << 1, l, mid, d);
        add(u << 1 | 1, mid + 1, r, d);
      }

      pushUp(u);
    }
  }
}

