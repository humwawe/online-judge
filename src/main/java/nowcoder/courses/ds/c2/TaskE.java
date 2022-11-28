package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskE {


  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int p = in.nextInt();
    int[] w = in.nextInt(n);
    SegmentTree3 segmentTree3 = new SegmentTree3(n, p, w);

    segmentTree3.build(1, 0, n - 1);

    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      if (t == 1) {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        int v = in.nextInt();
        segmentTree3.add(1, l, r, v);

      } else if (t == 2) {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        int v = in.nextInt();
        segmentTree3.mul(1, l, r, v);
      } else {
        int l = in.nextInt() - 1;
        int r = in.nextInt() - 1;
        out.println(segmentTree3.query(1, l, r)[1]);
      }
    }

  }

  class SegmentTree3 {
    int N;
    int[] left;
    int[] right;
    long[] sum;
    long[] res;
    long[] add;
    long[] mul;
    int[] w;
    int mod;

    public SegmentTree3(int n, int p, int[] w) {
      N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      sum = new long[N * 4];
      res = new long[N * 4];
      add = new long[N * 4];
      mul = new long[N * 4];
      this.w = w;
      mod = p;
      Arrays.fill(mul, 1);
    }

    void pushUp(int u) {
      pushDown(u << 1);
      pushDown(u << 1 | 1);
      sum[u] = (sum[u << 1] + sum[u << 1 | 1]) % mod;
      res[u] = (res[u << 1] + res[u << 1 | 1] + sum[u << 1] * sum[u << 1 | 1] % mod) % mod;
    }

    void pushDown(int u) {
      // 有tag
      if (add[u] != 0 || mul[u] != 1) {
        // calLazy(u): 计算当前tag的当前层的影响
        long len = (right[u] - left[u] + 1) % mod;
        res[u] = (mul[u] * mul[u] % mod * res[u] % mod + mul[u] * add[u] % mod * (len - 1) % mod * sum[u] % mod + len * (len - 1) / 2 % mod * add[u] % mod * add[u] % mod) % mod;
        sum[u] = (sum[u] * mul[u] % mod + len * add[u] % mod) % mod;

        //  unionLazy: 有儿子节点，向下传递tag
        // tag对儿子层的影响未计算，每次查询时候发现有tag需要先pushDown
        if (left[u] != right[u]) {
          mul[u << 1] = mul[u] * mul[u << 1] % mod;
          add[u << 1] = (add[u << 1] * mul[u] % mod + add[u]) % mod;
          mul[u << 1 | 1] = mul[u] * mul[u << 1 | 1] % mod;
          add[u << 1 | 1] = (add[u << 1 | 1] * mul[u] % mod + add[u]) % mod;
        }
        // initLazy(u): tag恢复
        add[u] = 0;
        mul[u] = 1;
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

    long[] query(int u, int l, int r) {
      pushDown(u);

      // 已经完全在[l,r]中了
      if (left[u] >= l && right[u] <= r) {
        return new long[]{sum[u], res[u]};
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return merge(query(u << 1, l, r), query(u << 1 | 1, l, r));
      }

    }

    private long[] merge(long[] l, long[] r) {
      long[] tmp = new long[2];
      tmp[0] = (l[0] + r[0]) % mod;
      tmp[1] = (l[1] + r[1] + l[0] * r[0] % mod) % mod;
      return tmp;
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
