package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] w = in.nextInt(n);
    SegmentTree3 segmentTree3 = new SegmentTree3(n, w);

    segmentTree3.build(1, 0, n - 1);

    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      if (t == 4) {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        int v = in.nextInt();
        segmentTree3.add(1, l, r, v);

      } else if (t == 3) {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        int v = in.nextInt();
        segmentTree3.mul(1, l, r, v);
      } else if (t == 1) {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        out.println(segmentTree3.query(1, l, r));
      } else if (t == 2) {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        out.println(segmentTree3.query2(1, l, r));
      }
    }

  }

  class SegmentTree3 {
    int N;
    int[] left;
    int[] right;
    long[] sum;
    long[] sum2;
    long[] add;
    long[] mul;
    int[] w;

    public SegmentTree3(int n, int[] w) {
      N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      sum = new long[N * 4];
      sum2 = new long[N * 4];
      add = new long[N * 4];
      mul = new long[N * 4];
      this.w = w;
      Arrays.fill(mul, 1);
    }

    void pushUp(int u) {
      pushDown(u << 1);
      pushDown(u << 1 | 1);
      sum[u] = (sum[u << 1] + sum[u << 1 | 1]);
      sum2[u] = (sum2[u << 1] + sum2[u << 1 | 1]);
    }

    void pushDown(int u) {
      // 有tag
      if (add[u] != 0 || mul[u] != 1) {
        // calLazy(u): 计算当前tag的当前层的影响
        long len = (right[u] - left[u] + 1);
        sum2[u] = (mul[u] * mul[u] * sum2[u] + 2 * mul[u] * add[u] * sum[u] + len * add[u] * add[u]);
        sum[u] = (sum[u] * mul[u] + len * add[u]);


        if (left[u] != right[u]) {
          mul[u << 1] = mul[u] * mul[u << 1];
          add[u << 1] = (add[u << 1] * mul[u] + add[u]);
          mul[u << 1 | 1] = mul[u] * mul[u << 1 | 1];
          add[u << 1 | 1] = (add[u << 1 | 1] * mul[u] + add[u]);
        }
        add[u] = 0;
        mul[u] = 1;
      }
    }

    void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        sum[u] = w[r];
        sum2[u] = w[r] * w[r];
        return;
      }

      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    long query(int u, int l, int r) {
      pushDown(u);

      // 已经完全在[l,r]中了
      if (left[u] >= l && right[u] <= r) {
        return sum[u];
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return query(u << 1, l, r) + query(u << 1 | 1, l, r);
      }

    }

    long query2(int u, int l, int r) {
      pushDown(u);

      // 已经完全在[l,r]中了
      if (left[u] >= l && right[u] <= r) {
        return sum2[u];
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query2(u << 1, l, r);
      } else if (l > mid) {
        return query2(u << 1 | 1, l, r);
      } else {
        return query2(u << 1, l, r) + query2(u << 1 | 1, l, r);
      }

    }


    void add(int u, int l, int r, int d) {
      pushDown(u);

      if (left[u] >= l && right[u] <= r) {
        add[u] = d;
        return;
      }

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

    void mul(int u, int l, int r, int d) {
      pushDown(u);

      if (left[u] >= l && right[u] <= r) {
        mul[u] = d;
        return;
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        mul(u << 1, l, r, d);
      } else if (l > mid) {
        mul(u << 1 | 1, l, r, d);
      } else {
        mul(u << 1, l, r, d);
        mul(u << 1 | 1, l, r, d);
      }

      pushUp(u);
    }


  }
}
