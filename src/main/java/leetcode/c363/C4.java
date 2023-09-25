package leetcode.c363;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class C4 {
  public long maximumSum(List<Integer> nums) {
    int n = nums.size();
    List<Integer>[] lists = new List[n];
    Arrays.setAll(lists, e -> new ArrayList<>());
    int idx = 0;
    f:
    for (int i = 1; i <= n; i++) {

      for (int j = 0; j < idx; j++) {
        int last = lists[j].get(lists[j].size() - 1);
        int cur = last * i;
        int sqrt = (int) Math.sqrt(cur);
        if (sqrt * sqrt == cur) {
          lists[j].add(i);
          continue f;
        }
      }
      lists[idx].add(i);
      idx++;
    }
    long res = 0;
    for (List<Integer> list : lists) {
      long t = 0;
      for (Integer integer : list) {
        t += nums.get(integer - 1);
      }
      res = Math.max(res, t);
    }
    return res;
  }
}
