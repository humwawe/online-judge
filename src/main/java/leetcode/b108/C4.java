package leetcode.b108;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class C4 {
  public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
    long[] res = new long[5];
    long base = (long) 1e6;
    Set<Long> set = new HashSet<>();
    Set<Long> cs = new HashSet<>();
    for (int[] coordinate : coordinates) {
      set.add(coordinate[0] * base + coordinate[1]);
      cs.add(coordinate[0] * base + coordinate[1]);
      cs.add((coordinate[0] - 1) * base + coordinate[1]);
      cs.add(coordinate[0] * base + (coordinate[1] - 1));
      cs.add((coordinate[0] - 1) * base + coordinate[1] - 1);
    }

    for (Long c : cs) {
      int x = (int) (c / base);
      int y = (int) (c % base);
      int cur = 0;

      if (x >= 0 && x < m && y >= 0 && y < n) {
        if (set.contains(x * base + y)) {
          cur++;
        }
      } else {
        continue;
      }
      if (x + 1 >= 0 && x + 1 < m && y >= 0 && y < n) {
        if (set.contains((x + 1) * base + y)) {
          cur++;
        }
      } else {
        continue;
      }
      if (x >= 0 && x < m && y + 1 >= 0 && y + 1 < n) {
        if (set.contains(x * base + y + 1)) {
          cur++;
        }
      } else {
        continue;
      }
      if (x + 1 >= 0 && x + 1 < m && y + 1 >= 0 && y + 1 < n) {
        if (set.contains((x + 1) * base + y + 1)) {
          cur++;
        }
      } else {
        continue;
      }
      if (cur != 0) {
        res[cur]++;
      }
    }
    long t = 0;
    for (long r : res) {
      t += r;
    }
    res[0] = (long) (m - 1) * (n - 1) - t;
    return res;

  }


}
