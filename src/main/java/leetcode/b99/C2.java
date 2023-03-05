package leetcode.b99;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class C2 {
  public int countWays(int[][] ranges) {
    int mod = (int) (1e9 + 7);

    Arrays.sort(ranges, Comparator.comparingInt(x -> x[0]));

    int n = ranges.length;
    int last = -1;
    int res = 1;
    for (int i = 0; i < n; i++) {
      if (ranges[i][0] > last) {
        res = (res * 2) % mod;
      }
      last = Math.max(last, ranges[i][1]);
    }
    return res;
  }
}
