package leetcode.c328;

import java.util.Arrays;

/**
 * @author hum
 */
public class C2 {
  public static void main(String[] args) {
    C2 c2 = new C2();
    System.out.println(Arrays.deepToString(c2.rangeAddQueries(2, new int[][]{{0, 0, 1, 1}})));
  }

  public int[][] rangeAddQueries(int n, int[][] queries) {
    int[][] diff = new int[n + 1][n + 1];
    for (int[] query : queries) {
      twoChange(diff, query[0] + 1, query[1] + 1, query[2] + 1, query[3] + 1, 1);
    }

    int[][] sum = new int[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + diff[i][j];
      }
    }
    int[][] res = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        res[i][j] = sum[i + 1][j + 1];
      }
    }
    return res;
  }


  void twoChange(int[][] diff, int x1, int y1, int x2, int y2, int v) {
    diff[x1 - 1][y1 - 1] += v;
    diff[x1 - 1][y2] -= v;
    diff[x2][y1 - 1] -= v;
    diff[x2][y2] += v;
  }

}
