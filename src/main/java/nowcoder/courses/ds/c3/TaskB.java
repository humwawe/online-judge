package nowcoder.courses.ds.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.PriorityQueue;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int k = in.nextInt();
    SegmentLazyTree segmentLazyTree = new SegmentLazyTree(n);
    for (int i = 0; i < m; i++) {
      int p = in.nextInt() - 1;
      int a = in.nextInt();
      segmentLazyTree.add(1, p, p, a);
    }
    for (int i = 0; i < k; i++) {
      int l = in.nextInt() - 1;
      int r = in.nextInt() - 1;
      int p = in.nextInt();
      out.println(segmentLazyTree.query(1, l, r, p));
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
    PriorityQueue<Integer>[] ws;

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
      ws = new PriorityQueue[N * 4];
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
        sum[u] = 0;
        min[u] = 0;
        max[u] = 0;

        // unionLazy: 有儿子节点，向下传递tag
        // tag对儿子层的影响未计算，每次查询时候发现有tag需要先pushDown
        if (left[u] != right[u]) {
          add[u << 1] = add[u];
          add[u << 1 | 1] = add[u];
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
        ws[u] = new PriorityQueue<>((x, y) -> y - x);
        return;
      }

      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    // 从u开始查找
    long query(int u, int l, int r, int x) {
      pushDown(u);

      // 已经完全在[l,r]中了
      if (left[u] == l && right[u] == r) {
        if (min[u] >= x) {
          add[u] = 1;
          return sum[u];
        }

        if (max[u] < x) {
          return 0;
        }

        if (left[u] == right[u]) {
          long res = 0;
          while (!ws[u].isEmpty() && ws[u].peek() >= x) {
            int t = ws[u].poll();
            res += t;
            sum[u] -= t;
          }
          if (ws[u].isEmpty()) {
            max[u] = 0;
            min[u] = 0;
          } else {
            max[u] = ws[u].peek();
          }
          return res;
        }

      }

      int mid = left[u] + right[u] >> 1;
      long res = 0;
      if (r <= mid) {
        res = query(u << 1, l, r, x);
      } else if (l > mid) {
        res = query(u << 1 | 1, l, r, x);
      } else {
        // merge(query(u << 1, l, r), query(u << 1 | 1, l, r))
        res = query(u << 1, l, mid, x) + query(u << 1 | 1, mid + 1, r, x);
      }

      pushUp(u);
      return res;
    }

    void add(int u, int l, int r, int v) {
      // assert l==r
      pushDown(u);

      if (left[u] == l && right[u] == r) {
        if (ws[u].isEmpty()) {
          min[u] = v;
          max[u] = v;
        } else {
          min[u] = Math.min(min[u], v);
          max[u] = Math.max(max[u], v);
        }
        sum[u] += v;
        ws[u].add(v);
        return;
      }

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        add(u << 1, l, r, v);
      } else if (l > mid) {
        add(u << 1 | 1, l, r, v);
      } else {
        add(u << 1, l, mid, v);
        add(u << 1 | 1, mid + 1, r, v);
      }

      pushUp(u);
    }
  }
}
