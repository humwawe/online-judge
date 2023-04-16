package leetcode.c341;

/**
 * @author hum
 */
public class C1 {
  public int[] rowAndMaximumOnes(int[][] mat) {
    int[] res = new int[2];
    int n = mat.length;
    int m = mat[0].length;
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 1) {
          cnt++;
        }
      }
      if (cnt > res[1]) {
        res[0] = i;
        res[1] = cnt;
      }
    }
    return res;
  }
}
