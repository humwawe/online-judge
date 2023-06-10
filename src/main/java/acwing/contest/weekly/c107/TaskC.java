package acwing.contest.weekly.c107;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int m = in.nextInt();
    SegmentLazyTree[] segmentLazyTrees = new SegmentLazyTree[21];
    for (int i = 0; i < 21; i++) {
      int[] b = new int[n];
      for (int j = 0; j < n; j++) {
        if ((a[j] >> i & 1) == 1) {
          b[j] = 1;
        }
      }
      segmentLazyTrees[i] = new SegmentLazyTree(n, b);
    }


    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      int l = in.nextInt() - 1;
      int r = in.nextInt() - 1;
      if (t == 1) {
        long res = 0;
        for (int j = 0; j < 21; j++) {
          res += (1 << j) * segmentLazyTrees[j].query(1, l, r);
        }
        out.println(res);
      } else {
        int x = in.nextInt();
        for (int j = 0; j < 21; j++) {
          if ((x >> j & 1) == 1) {
            segmentLazyTrees[j].add(1, l, r, 1);
          }
        }
      }
    }
  }

  class SegmentLazyTree {
    int N;
    int[] left;
    int[] right;
    long[] sum;
    long[] add;
    int[] w;

    public SegmentLazyTree(int n) {
      this(n, new int[n]);
    }


    public SegmentLazyTree(int n, int[] w) {
      N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      sum = new long[N * 4];
      add = new long[N * 4];
      this.w = w;
      build(1, 0, n - 1);
    }

    void pushUp(int u) {
      pushDown(u << 1);
      pushDown(u << 1 | 1);
      sum[u] = sum[u << 1] + sum[u << 1 | 1];

    }

    void pushDown(int u) {
      if (add[u] != 0) {
        sum[u] = (right[u] - left[u] + 1) - sum[u];
        if (left[u] != right[u]) {
          add[u << 1] ^= add[u];
          add[u << 1 | 1] ^= add[u];
        }
        add[u] = 0;
      }
    }

    void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        sum[u] = w[r];
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
        return sum[u];
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        // merge(query(u << 1, l, r), query(u << 1 | 1, l, r))
        return query(u << 1, l, mid) + query(u << 1 | 1, mid + 1, r);
      }

    }

    void add(int u, int l, int r, int d) {
      pushDown(u);

      if (left[u] == l && right[u] == r) {
        add[u] ^= d;
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
