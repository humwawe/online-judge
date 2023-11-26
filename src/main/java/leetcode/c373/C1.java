package leetcode.c373;

import java.util.Arrays;

/**
 * @author hum
 */
public class C1 {
  public boolean areSimilar(int[][] mat, int k) {
    int n = mat.length;
    for (int i = 0; i < n; i++) {
      int[] res;
      if (i % 2 == 0) {
        res = helper(mat[i], k, 1);
      } else {
        res = helper(mat[i], k, -1);
      }
      if (!Arrays.equals(mat[i], res)) {
        return false;
      }
    }
    return true;
  }

  private int[] helper(int[] x, int k, int i) {
    int len = x.length;
    int[] res = new int[len];
    for (int j = 0; j < len; j++) {
      res[j] = x[((j - i * k) % len + len) % len];
    }
    return res;
  }
}
