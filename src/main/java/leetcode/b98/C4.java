package leetcode.b98;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C4 {
  public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
    List<Long> list = new ArrayList<>();
    long sum = 0;
    for (int i : nums2) {
      sum += i;
    }
    SegmentLazyTree segmentLazyTree = new SegmentLazyTree(nums1.length, nums1);
    for (int[] query : queries) {
      int t = query[0];
      if (t == 1) {
        int l = query[1];
        int r = query[2];
        segmentLazyTree.add(1, l, r, 1);
      } else if (t == 2) {
        int p = query[1];
        long q = segmentLazyTree.query(1, 0, nums1.length - 1);
        sum += p * q;
      } else {
        list.add(sum);
      }
    }
    long[] res = new long[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
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
      // 有tag
      if (add[u] != 0) {
        // calLazy(u): 计算当前tag的当前层的影响
        sum[u] = (right[u] - left[u] + 1) - sum[u];
        if (left[u] != right[u]) {
          add[u << 1] ^= add[u];
          add[u << 1 | 1] ^= add[u];
        }
        add[u] = 0;
      }
    }

    // 从u开始，构建[l,r]的树，w[i]存每个节点的值(从l到r)
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
