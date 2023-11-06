package leetcode.c370;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hum
 */
public class C4 {

  public long maxBalancedSubsequenceSum(int[] nums) {
    int n = nums.length;
    int[] t = new int[n];
    for (int i = 0; i < n; i++) {
      t[i] = nums[i] - i;
    }
    TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      treeMap.computeIfAbsent(t[i], e -> new ArrayList<>()).add(i);
    }

    SegmentTree segmentTree = new SegmentTree(n);
    long[] dp = new long[n];

    for (Map.Entry<Integer, List<Integer>> kv : treeMap.entrySet()) {
      int k = kv.getKey();
      List<Integer> list = kv.getValue();

      for (Integer idx : list) {
        long query = segmentTree.query(1, 0, idx - 1);
        dp[idx] = Math.max(query + nums[idx], nums[idx]);
        segmentTree.modify(1, idx, dp[idx]);
      }

    }

    long res = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, dp[i]);
    }
    return res;
  }

  class SegmentTree {
    int N;
    long[] w;
    int[] left;
    int[] right;
    long[] max;
    long inf = (long) 1e15;

    public SegmentTree(int n) {
      this(n, new long[n]);
    }

    public SegmentTree(int n, long[] w) {
      this.N = w.length + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      max = new long[N * 4];
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
        max[u] = -inf;
        return;
      }
      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    long query(int u, int l, int r) {
      if (l > r) {
        return -inf;
      }
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

    void modify(int u, int x, long v) {
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
