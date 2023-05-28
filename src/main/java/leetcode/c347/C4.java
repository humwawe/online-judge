package leetcode.c347;

import java.util.*;

/**
 * @author hum
 */
public class C4 {
  int n, m;
  int[][] mat;

  public int maxIncreasingCells(int[][] mat) {
    n = mat.length;
    m = mat[0].length;
    this.mat = mat;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map.computeIfAbsent(mat[i][j], e -> new ArrayList<>()).add(helper(i, j));
      }
    }

    Set<Integer> set = map.keySet();
    List<Integer> list = new ArrayList<>(set);
    Collections.sort(list);

    int[] row = new int[n];
    int[] col = new int[m];
    int[][] dist = new int[n][m];

    for (Integer integer : list) {
      List<Integer> points = map.get(integer);
      for (Integer point : points) {
        int x = point / m;
        int y = point % m;
        dist[x][y] = Math.max(row[x], col[y]) + 1;
      }
      for (Integer point : points) {
        int x = point / m;
        int y = point % m;
        row[x] = Math.max(row[x], dist[x][y]);
        col[y] = Math.max(col[y], dist[x][y]);
      }
    }
    int res = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        res = Math.max(res, dist[i][j]);
      }
    }
    return res;

  }

  private Integer helper(int i, int j) {
    return i * m + j;
  }
}
