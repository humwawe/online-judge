package leetcode.c344;

/**
 * @author hum
 */
public class C3 {
  public int[] colorTheArray(int n, int[][] queries) {
    int[] a = new int[n];
    int[] res = new int[queries.length];
    int cur = 0;
    for (int i = 0; i < queries.length; i++) {
      int j = queries[i][0];
      int c = queries[i][1];

      if (j > 0 && a[j] != 0 && a[j] == a[j - 1]) {
        cur--;
      }
      if (j < n - 1 && a[j] != 0 && a[j] == a[j + 1]) {
        cur--;
      }

      a[j] = c;

      if (j > 0 && a[j] == a[j - 1]) {
        cur++;
      }
      if (j < n - 1 && a[j] == a[j + 1]) {
        cur++;
      }

      res[i] = cur;
    }
    return res;
  }
}
