package leetcode.c359;

import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class C3 {
  public int maximizeTheProfit(int n, List<List<Integer>> offers) {
    offers.sort(Comparator.comparingInt(x -> x.get(0)));

    int[] dp = new int[n + 1];
    SegmentTree segmentTree = new SegmentTree(n + 1);
    for (List<Integer> offer : offers) {
      int l = offer.get(0) + 1;
      int r = offer.get(1) + 1;
      int g = offer.get(2);
      dp[r] = Math.max(dp[r], segmentTree.query(1, 0, l - 1) + g);
      segmentTree.modify(1, r, dp[r]);
    }
    return segmentTree.query(1, 0, n);

  }

  class SegmentTree {
    int N;
    int[] w;
    int[] left;
    int[] right;
    int[] max;

    public SegmentTree(int n) {
      this(n, new int[n]);
    }

    public SegmentTree(int n, int[] w) {
      this.N = w.length + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      max = new int[N * 4];
      this.w = w;
      build(1, 0, n - 1);
    }

    void pushUp(int u) {
      max[u] = Math.max(max[u << 1], max[u << 1 | 1]);
    }

    private void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        max[u] = w[r];
        return;
      }
      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    int query(int u, int l, int r) {
      if (left[u] == l && right[u] == r) {
        return max[u];
      }
      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return query(u << 1, l, r);
      } else if (l > mid) {
        return query(u << 1 | 1, l, r);
      } else {
        return Math.max(query(u << 1, l, mid), query(u << 1 | 1, mid + 1, r));
      }

    }


    void modify(int u, int x, int v) {
      if (left[u] == x && right[u] == x) {
        max[u] = v;
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
