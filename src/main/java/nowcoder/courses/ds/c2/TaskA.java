package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] a = in.nextLong(n);
    SegmentTree3 segmentTree3 = new SegmentTree3(n, a);
    segmentTree3.build(1, 0, n - 1);
    for (int i = 1; i <= m; i++) {
      int d = in.nextInt();
      int l = in.nextInt() - 1;
      int r = in.nextInt() - 1;
      long query = segmentTree3.query(1, l, r);
      if (query < d) {
        out.println(-1);
        out.println(i);
        return;
      }
      segmentTree3.add(1, l, r, -d);
    }
    out.println(0);

  }

  class SegmentTree3 {
    int N;
    int[] left;
    int[] right;
    long[] min;
    long[] add;
    long[] w;

    public SegmentTree3(int n, long[] a) {
      N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      min = new long[N * 4];
      add = new long[N * 4];
      w = a;
    }

    void pushUp(int u) {
      min[u] = Math.min(min[u << 1], min[u << 1 | 1]);

    }

    void pushDown(int u) {
      if (add[u] != 0) {
        add[u << 1] += add[u];
        min[u << 1] += add[u];
        add[u << 1 | 1] += add[u];
        min[u << 1 | 1] += add[u];
        add[u] = 0;
      }
    }

    // 从u开始，构建[l,r]的树，w[i]存每个节点的值(从l到r)
    void build(int u, int l, int r) {
      if (l == r) {
        left[u] = l;
        right[u] = r;
        min[u] = w[r];
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
      // 已经完全在[l,r]中了
      if (left[u] >= l && right[u] <= r) {
        return min[u];
      }
      pushDown(u);
      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return Math.min(query(u << 1, l, r), query(u << 1 | 1, l, r));
      }

    }

    void add(int u, int l, int r, int d) {
      if (left[u] >= l && right[u] <= r) {
        min[u] += d;
        add[u] += d;
        return;
      }
      // 分裂
      pushDown(u);

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        add(u << 1, l, r, d);
      } else if (l > mid) {
        add(u << 1 | 1, l, r, d);
      } else {
        add(u << 1, l, r, d);
        add(u << 1 | 1, l, r, d);
      }

      pushUp(u);
    }
  }
}
