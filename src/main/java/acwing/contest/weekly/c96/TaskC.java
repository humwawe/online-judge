package acwing.contest.weekly.c96;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int q = in.nextInt();
    SegmentTree segmentTree1 = new SegmentTree(n, b);
    SegmentTree segmentTree2 = new SegmentTree(n, a);
    for (int i = 0; i < q; i++) {
      int t = in.nextInt();
      if (t == 1) {
        int x = in.nextInt() - 1;
        int y = in.nextInt();
        segmentTree1.modify(1, x, y);
        segmentTree2.modify(1, x, y);
      } else {
        int p = in.nextInt();
        int res = segmentTree1.query(1, 0, p - 2) + segmentTree2.query(1, p + k - 1, n - 1);
        out.println(res);
      }

    }


  }

  class SegmentTree {
    int N;
    int[] w;
    int[] left;
    int[] right;
    int[] sum;
    int t;

    public SegmentTree(int n, int x) {
      this(n, new int[n]);
      this.t = x;
    }

    public SegmentTree(int n, int[] w) {
      this.N = w.length + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      sum = new int[N * 4];
      this.w = w;

      build(1, 0, n - 1);
    }

    void pushUp(int u) {
      sum[u] = sum[u << 1] + sum[u << 1 | 1];
    }

    private void build(int u, int l, int r) {
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

    int query(int u, int l, int r) {
      if (l > r) {
        return 0;
      }
      if (left[u] == l && right[u] == r) {
        return sum[u];
      }
      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return query(u << 1, l, mid) + query(u << 1 | 1, mid + 1, r);
      }

    }

    void modify(int u, int x, int v) {
      if (left[u] == x && right[u] == x) {
        sum[u] += v;
        if (sum[u] > t) {
          sum[u] = t;
        }
        return;
      }
      int mid = left[u] + right[u] >> 1;
      if (x <= mid) {
        modify(u << 1, x, v);
      } else {
        modify(u << 1 | 1, x, v);
      }
      pushUp(u);
    }
  }
}