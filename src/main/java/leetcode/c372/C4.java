package leetcode.c372;

/**
 * @author hum
 */
public class C4 {

  public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
    int n = heights.length;
    SegmentTree segmentTree = new SegmentTree(n, heights);
    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int a = Math.min(queries[i][0], queries[i][1]);
      int b = Math.max(queries[i][0], queries[i][1]);
      if (a == b) {
        res[i] = a;
        continue;
      }
      if (heights[b] > heights[a]) {
        res[i] = b;
        continue;
      }
      res[i] = segmentTree.search(1, b + 1, n - 1, Math.max(heights[a], heights[b]));
    }
    return res;

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

    int search(int u, int l, int r, int d) {
      if (l > r) {
        return -1;
      }
      if (left[u] == l && right[u] == r) {
        if (max[u] <= d) {
          return -1;
        }
        if (left[u] == right[u]) {
          return left[u];
        }
        int mid = left[u] + right[u] >> 1;
        if (max[u << 1] > d) {
          return search(u << 1, l, mid, d);
        } else {
          return search(u << 1 | 1, mid + 1, r, d);
        }
      }
      int mid = left[u] + right[u] >> 1;
      if (r <= mid) {
        return search(u << 1, l, r, d);
      } else if (l > mid) {
        return search(u << 1 | 1, l, r, d);
      } else {
        int pos = search(u << 1, l, mid, d);
        if (pos == -1) {
          return search(u << 1 | 1, mid + 1, r, d);
        }
        return pos;
      }
    }

  }
}
