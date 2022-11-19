package atcoder.abc278;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DAllAssignPointAdd {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] a = in.nextLong(n);
    SegmentTree3 segment = new SegmentTree3(n);
    segment.w = a;
    segment.build(1, 0, n - 1);

    int q = in.nextInt();
    long all = -1;
    for (int i = 0; i < q; i++) {
      int t = in.nextInt();
      if (t == 1) {
        all = in.nextInt();
        segment.set(1, 0, n - 1, all);
      } else if (t == 2) {
        int idx = in.nextInt() - 1;
        long v = in.nextInt();
        segment.set(1, idx, idx, segment.query(1, idx, idx) + v);

      } else {
        int idx = in.nextInt() - 1;
        out.println(segment.query(1, idx, idx));
      }
    }

  }

  class SegmentTree3 {
    int N;
    int[] left;
    int[] right;
    long[] sum;
    long[] add;
    long[] w;

    public SegmentTree3(int n) {
      N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      sum = new long[N * 4];
      add = new long[N * 4];
      w = new long[n];
    }

    void pushUp(int u) {
      sum[u] = sum[u << 1] + sum[u << 1 | 1];

    }

    void pushDown(int u) {
      if (add[u] != 0) {
        add[u << 1] = add[u];
        sum[u << 1] = (right[u << 1] - left[u << 1] + 1) * add[u];
        add[u << 1 | 1] = add[u];
        sum[u << 1 | 1] = (right[u << 1 | 1] - left[u << 1 | 1] + 1) * add[u];
        add[u] = 0;
      }
    }

    // 从u开始，构建[l,r]的树，w[i]存每个节点的值(从l到r)
    void build(int u, int l, int r) {
      if (l == r) {
        left[u] = l;
        right[u] = r;
        sum[u] = w[r];
        return;
      }
      left[u] = l;
      right[u] = r;
      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    // 从u开始查找
    long query(int u, int l, int r) {
      if (left[u] >= l && right[u] <= r) {
        return sum[u];
      }
      pushDown(u);
      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return query(u << 1, l, r) + query(u << 1 | 1, l, r);
      }

    }

    void set(int u, int l, int r, long d) {
      if (left[u] >= l && right[u] <= r) {
        sum[u] = (right[u] - left[u] + 1) * d;
        add[u] = d;
        return;
      }
      // 分裂
      pushDown(u);

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        set(u << 1, l, r, d);
      } else if (l > mid) {
        set(u << 1 | 1, l, r, d);
      } else {
        set(u << 1, l, r, d);
        set(u << 1 | 1, l, r, d);
      }

      pushUp(u);
    }
  }

}
