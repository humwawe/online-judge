package nowcoder.courses.ds.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskD {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n);
    SegmentLazyTree segmentLazyTree = new SegmentLazyTree(n, a);
    for (int i = 0; i < m; i++) {
      int t = in.nextInt();
      int l = in.nextInt() - 1;
      int r = in.nextInt() - 1;
      if (t == 1) {
        segmentLazyTree.add(1, l, r);
      } else {
        out.println(segmentLazyTree.query(1, l, r));
      }
    }
  }

  class SegmentLazyTree {
    int N;
    int[] left;
    int[] right;
    long[] sum;
    long[] add;
    long[] max;
    long[] min;
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
      max = new long[N * 4];
      min = new long[N * 4];
      this.w = w;
      build(1, 0, n - 1);
    }

    void pushUp(int u) {
      pushDown(u << 1);
      pushDown(u << 1 | 1);
      sum[u] = sum[u << 1] + sum[u << 1 | 1];
      max[u] = Math.max(max[u << 1], max[u << 1 | 1]);
      min[u] = Math.min(min[u << 1], min[u << 1 | 1]);
    }

    void pushDown(int u) {
      // 有tag
      if (add[u] != 0) {
        // calLazy(u): 计算当前tag的当前层的影响
        sum[u] = (right[u] - left[u] + 1) * add[u];
        // unionLazy: 有儿子节点，向下传递tag
        // tag对儿子层的影响未计算，每次查询时候发现有tag需要先pushDown
        if (left[u] != right[u]) {
          add[u << 1] += add[u];
          add[u << 1 | 1] += add[u];
        }
        // initLazy(u): tag恢复
        add[u] = 0;
      }
    }

    // 从u开始，构建[l,r]的树，w[i]存每个节点的值(从l到r)
    void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        sum[u] = w[r];
        max[u] = w[r];
        min[u] = w[r];
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

    void add(int u, int l, int r) {
      pushDown(u);

      if (left[u] == l && right[u] == r) {
        if (max[u] == min[u] && max[u] == 1) {
          return;
        }
        if (left[u] == right[u]) {
          max[u] = (long) Math.sqrt(max[u]);
          min[u] = (long) Math.sqrt(min[u]);
          sum[u] = (long) Math.sqrt(sum[u]);
          return;
        }
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        add(u << 1, l, r);
      } else if (l > mid) {
        add(u << 1 | 1, l, r);
      } else {
        add(u << 1, l, mid);
        add(u << 1 | 1, mid + 1, r);
      }

      pushUp(u);
    }
  }
}
