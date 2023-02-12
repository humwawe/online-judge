package leetcode.c332;

import java.util.*;

/**
 * @author hum
 */
public class C3 {
  public int[][] substringXorQueries(String s, int[][] queries) {
    int n = s.length();
    int len = queries.length;
    int[][] res = new int[len][2];

    int[] qs = new int[len];
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      int x = queries[i][0];
      int y = queries[i][1];
      int t = x ^ y;
      map.put(t, map.computeIfAbsent(t, e -> new ArrayList<>())).add(i);
      Arrays.fill(res[i], -1);
    }

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        int x = 0;
        for (int j = 0; j < 32 && i + j < n; j++) {
          x |= s.charAt(i + j) - '0';
          if (map.containsKey(x)) {
            List<Integer> list = map.get(x);
            for (Integer integer : list) {
              res[integer][0] = i;
              res[integer][1] = i + j;
            }
            map.remove(x);
          }
          x <<= 1;
        }
      }
    }
    if (map.containsKey(0)) {
      int i = s.indexOf('0');
      if (i >= 0) {
        List<Integer> list = map.get(0);
        for (Integer integer : list) {
          res[integer][0] = i;
          res[integer][1] = i;
        }
      }
    }
    return res;
  }
}
