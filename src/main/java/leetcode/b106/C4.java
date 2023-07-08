package leetcode.b106;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class C4 {

  public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int l = (1 << m) - 1;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int st = 0;
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          st |= 1 << j;
        }
      }
      if (st == 0) {
        List<Integer> res = new ArrayList<>();
        res.add(i);
        return res;
      }
      int need = l ^ st;
      int sub = need;

      do {
        if (map.containsKey(sub)) {
          List<Integer> res = new ArrayList<>();
          res.add(map.get(sub));
          res.add(i);
          return res;
        }
        sub = (sub - 1) & need;
      } while (sub != need);


      map.put(st, i);
    }
    return new ArrayList<>();
  }
}
