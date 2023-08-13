package leetcode.c357;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author hum
 */
public class C4 {

  public long findMaximumElegance(int[][] items, int k) {
    Arrays.sort(items, (x, y) -> y[0] - x[0]);
    int n = items.length;
    Set<Integer> set = new HashSet<>();
    Stack<Integer> stack = new Stack<>();
    long res = 0;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      int v = items[i][0];
      int t = items[i][1];
      if (i < k) {
        sum += v;
        if (set.contains(t)) {
          stack.add(v);
        }
        set.add(t);
      } else {
        if (!stack.isEmpty() && !set.contains(t)) {
          sum -= stack.pop();
          sum += v;
          set.add(t);
        }
      }
      res = Math.max(res, sum + (long) set.size() * set.size());
    }
    return res;
  }
}
