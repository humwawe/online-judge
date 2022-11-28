package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskI {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    SegmentLazyTree segmentLazyTree = new SegmentLazyTree(n);

    for (int i = 0; i < m; i++) {
      char q = in.nextCharacter();
      if (q == 'x') {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        int v = in.nextInt();
        segmentLazyTree.add(1, l, r, v, 1);
      } else if (q == 'y') {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        int v = in.nextInt();
        segmentLazyTree.add(1, l, r, v, 2);
      } else if (q == 'z') {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        int v = in.nextInt();
        segmentLazyTree.add(1, l, r, v, 3);
      } else {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        out.println(segmentLazyTree.query(1, l, r));
      }
    }
  }


  class SegmentLazyTree {
    int N;
    int[] left;
    int[] right;
    long[] xyz;
    long[] xy;
    long[] xz;
    long[] yz;
    long[] x;
    long[] y;
    long[] z;
    long[] a;
    long[] b;
    long[] c;
    int[] w;
    int mod = (int) (1e9 + 7);

    public SegmentLazyTree(int n) {
      this(n, new int[n]);
    }


    public SegmentLazyTree(int n, int[] w) {
      N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      xyz = new long[N * 4];
      xy = new long[N * 4];
      xz = new long[N * 4];
      yz = new long[N * 4];
      x = new long[N * 4];
      y = new long[N * 4];
      z = new long[N * 4];
      a = new long[N * 4];
      b = new long[N * 4];
      c = new long[N * 4];
      this.w = w;
      build(1, 0, n - 1);
    }

    void pushUp(int u) {
      pushDown(u << 1);
      pushDown(u << 1 | 1);
      xyz[u] = add(xyz[u << 1], xyz[u << 1 | 1]);
      xy[u] = add(xy[u << 1], xy[u << 1 | 1]);
      xz[u] = add(xz[u << 1], xz[u << 1 | 1]);
      yz[u] = add(yz[u << 1], yz[u << 1 | 1]);
      x[u] = add(x[u << 1], x[u << 1 | 1]);
      y[u] = add(y[u << 1], y[u << 1 | 1]);
      z[u] = add(z[u << 1], z[u << 1 | 1]);
    }

    long add(long... a) {
      long c = 0;
      for (long l : a) {
        c += l;
      }
      while (c >= mod) {
        c -= mod;
      }
      return c;
    }

    void pushDown(int u) {
      long len = right[u] - left[u] + 1;
      if (a[u] != 0 || b[u] != 0 || c[u] != 0) {
        xyz[u] = add(len * a[u] % mod * b[u] % mod * c[u] % mod +
            a[u] * b[u] % mod * z[u] % mod +
            a[u] * y[u] % mod * c[u] % mod +
            a[u] * yz[u] % mod +
            x[u] * b[u] % mod * c[u] % mod +
            xz[u] * b[u] % mod +
            xy[u] * c[u] % mod +
            xyz[u]);


        xy[u] = add(a[u] * b[u] % mod * len % mod +
            a[u] * y[u] % mod +
            b[u] * x[u] % mod +
            xy[u]);

        xz[u] = add(a[u] * c[u] % mod * len % mod +
            a[u] * z[u] % mod +
            c[u] * x[u] % mod +
            xz[u]);

        yz[u] = add(b[u] * c[u] % mod * len % mod +
            b[u] * z[u] % mod +
            c[u] * y[u] % mod +
            yz[u]);

        x[u] = add(a[u] * len % mod, x[u]);
        y[u] = add(b[u] * len % mod, y[u]);
        z[u] = add(c[u] * len % mod, z[u]);

        // unionLazy: 有儿子节点，向下传递tag
        // tag对儿子层的影响未计算，每次查询时候发现有tag需要先pushDown
        if (left[u] != right[u]) {
          a[u << 1] = add(a[u << 1], a[u]);
          a[u << 1 | 1] = add(a[u << 1 | 1], a[u]);
          b[u << 1] = add(b[u << 1], b[u]);
          b[u << 1 | 1] = add(b[u << 1 | 1], b[u]);
          c[u << 1] = add(c[u << 1], c[u]);
          c[u << 1 | 1] = add(c[u << 1 | 1], c[u]);
        }
        // initLazy(u): tag恢复
        a[u] = 0;
        b[u] = 0;
        c[u] = 0;
      }
    }

    // 从u开始，构建[l,r]的树，w[i]存每个节点的值(从l到r)
    void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        xyz[u] = 1;
        xy[u] = 1;
        xz[u] = 1;
        yz[u] = 1;
        x[u] = 1;
        y[u] = 1;
        z[u] = 1;
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

      // 已经完全在[l,r]中了
      if (left[u] == l && right[u] == r) {
        return xyz[u];
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return add(query(u << 1, l, mid), query(u << 1 | 1, mid + 1, r));
      }

    }

    void add(int u, int l, int r, long d, int t) {
      pushDown(u);

      if (left[u] == l && right[u] == r) {
        if (t == 1) {
          a[u] = d;
        } else if (t == 2) {
          b[u] = d;
        } else {
          c[u] = d;
        }
        return;
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        add(u << 1, l, r, d, t);
      } else if (l > mid) {
        add(u << 1 | 1, l, r, d, t);
      } else {
        add(u << 1, l, mid, d, t);
        add(u << 1 | 1, mid + 1, r, d, t);
      }

      pushUp(u);
    }
  }
}
