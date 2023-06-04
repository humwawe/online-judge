package leetcode.c348;

/**
 * @author hum
 */
public class C3 {
  public long matrixSumQueries(int n, int[][] queries) {
    int len = queries.length;
    long res = 0;
    boolean[] row = new boolean[n];
    boolean[] col = new boolean[n];
    long r = n;
    long c = n;
    for (int i = len - 1; i >= 0; i--) {
      int t = queries[i][0];
      int j = queries[i][1];
      int v = queries[i][2];
      if (t == 0) {
        if (row[j]) {
          continue;
        }
        res += v * c;
        row[j] = true;
        r--;
      } else {
        if (col[j]) {
          continue;
        }
        res += v * r;
        col[j] = true;
        c--;
      }
    }
    return res;
  }
}
