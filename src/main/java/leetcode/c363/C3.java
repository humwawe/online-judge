package leetcode.c363;

import java.util.List;

/**
 * @author hum
 */
public class C3 {
  public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {

    int res = 0;

    for (int i = 0; i < k; i++) {
      int l = 0;
      int r = (int) 1e9;
      while (l < r) {
        int mid = l + r + 1 >> 1;
        long sum = 0;
        for (int j = 0; j < n; j++) {
          sum += Math.max(0, (long) mid * composition.get(i).get(j) - (long) stock.get(j)) * cost.get(j);
        }
        if (sum <= budget) {
          l = mid;
        } else {
          r = mid - 1;
        }
      }
      res = Math.max(res, l);
    }
    return res;
  }
}
