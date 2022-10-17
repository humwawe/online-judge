package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class EXOROnSegment {
  int[] w;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int b = 21;
    w = new int[n];
    SegmentTree[] segmentTrees = new SegmentTree[b];
    Arrays.setAll(segmentTrees, e -> new SegmentTree(n));
    for (int i = 0; i < b; i++) {
      for (int j = 0; j < n; j++) {
        w[j] = ((a[j] >> i) & 1);
      }
      segmentTrees[i].build(1, 0, n - 1);
    }
    int q = in.nextInt();
    for (int i = 0; i < q; i++) {
      int t = in.nextInt();
      int l = in.nextInt() - 1;
      int r = in.nextInt() - 1;
      if (t == 1) {
        long sum = 0;
        for (int j = 0; j < b; j++) {
          sum += (long) segmentTrees[j].query(1, l, r) * (1 << j);
        }
        out.println(sum);
      } else {
        int x = in.nextInt();
        for (int j = 0; j < b; j++) {
          if ((x >> j & 1) == 1) {
            segmentTrees[j].modify(1, l, r);
          }
        }
      }
    }
  }

  class SegmentTree {
    int N;
    int[] left;
    int[] right;
    int[] sum;
    int[] add;

    public SegmentTree(int n) {
      N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      sum = new int[N * 4];
      add = new int[N * 4];
    }

    void pushUp(int u) {
      sum[u] = sum[u << 1] + sum[u << 1 | 1];

    }

    void pushDown(int u) {
      if (add[u] != 0) {
        add[u << 1] ^= add[u];
        sum[u << 1] = (right[u << 1] - left[u << 1] + 1 - sum[u << 1]);
        add[u << 1 | 1] ^= add[u];
        sum[u << 1 | 1] = (right[u << 1 | 1] - left[u << 1 | 1] + 1 - sum[u << 1 | 1]);
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
    int query(int u, int l, int r) {
      // 已经完全在[l,r]中了
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

    void modify(int u, int l, int r) {
      if (left[u] >= l && right[u] <= r) {
        sum[u] = (right[u] - left[u] + 1 - sum[u]);
        add[u] ^= 1;
        return;
      }
      // 分裂
      pushDown(u);

      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        modify(u << 1, l, r);
      } else if (l > mid) {
        modify(u << 1 | 1, l, r);
      } else {
        modify(u << 1, l, r);
        modify(u << 1 | 1, l, r);
      }

      pushUp(u);
    }
  }
}