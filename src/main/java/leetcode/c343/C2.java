package leetcode.c343;

/**
 * @author hum
 */
public class C2 {
  public int firstCompleteIndex(int[] arr, int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int sum = n * m;
    int[] idx = new int[sum + 1];
    for (int i = 0; i < arr.length; i++) {
      idx[arr[i]] = i;
    }
    int res = arr.length;
    for (int i = 0; i < n; i++) {
      int t = 0;
      for (int j = 0; j < m; j++) {
        t = Math.max(t, idx[mat[i][j]]);
      }
      res = Math.min(res, t);
    }
    for (int i = 0; i < m; i++) {
      int t = 0;
      for (int j = 0; j < n; j++) {
        t = Math.max(t, idx[mat[j][i]]);
      }
      res = Math.min(res, t);
    }
    return res;
  }
}
