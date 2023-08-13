package leetcode.c358;

import java.util.List;
import java.util.TreeSet;

/**
 * @author hum
 */
public class C3 {

  public int minAbsoluteDifference(List<Integer> nums, int x) {
    int n = nums.size();
    TreeSet<Long> set = new TreeSet<>();
    long inf = (long) 1e15;
    long res = inf;
    set.add(inf);
    set.add(-inf);
    for (int i = 0; i < n; i++) {
      if (i - x >= 0) {
        set.add(Long.valueOf(nums.get(i - x)));
      }

      Long floor = set.floor(Long.valueOf(nums.get(i)));
      Long ceiling = set.ceiling(Long.valueOf(nums.get(i)));
      res = Math.min(res, (long) nums.get(i) - floor);
      res = Math.min(res, ceiling - (long) nums.get(i));


    }
    return (int) res;
  }
}
