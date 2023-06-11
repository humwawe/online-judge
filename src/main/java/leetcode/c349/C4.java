package leetcode.c349;

import java.util.Arrays;

/**
 * @author hum
 */
public class C4 {
  public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
    int n = nums1.length;
    int len = queries.length;
    int[][] a = new int[n + len][];
    for (int i = n - 1; i >= 0; i--) {
      a[i] = new int[]{nums1[i], nums2[i], -1};
    }
    for (int i = 0; i < len; i++) {
      a[i + n] = new int[]{queries[i][0], queries[i][1], i};
    }
    Arrays.sort(a, (x, y) -> {
      if (x[0] != y[0]) {
        return -(x[0] - y[0]);
      }
      return x[2] - y[2];
    });

    int[] xs = new int[n + 1];
    int[] ys = new int[n + 1];
    int p = 0;
    int[] res = new int[len];
    Arrays.fill(res, -1);
    for (int[] e : a) {
      if (e[2] == -1) {
        if (p > 0 && e[1] <= ys[p - 1]) {
          continue;
        }
        while (p > 0 && e[0] + e[1] >= xs[p - 1] + ys[p - 1]) {
          p--;
        }
        xs[p] = e[0];
        ys[p++] = e[1];
      } else {
        if (p > 0) {
          int lb = helper(ys, 0, p, e[1]);
          if (ys[lb] >= e[1]) {
            res[e[2]] = Math.max(res[e[2]], xs[lb] + ys[lb]);
          }
        }
      }
    }
    return res;
  }

  private int helper(int[] ys, int l, int r, int v) {
    r--;
    while (l < r) {
      int mid = l + r >> 1;
      if (ys[mid] >= v) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}
