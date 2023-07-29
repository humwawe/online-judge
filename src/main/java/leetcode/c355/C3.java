package leetcode.c355;

import java.util.List;

/**
 * @author hum
 */
public class C3 {

  public int maxIncreasingGroups(List<Integer> usageLimits) {
    int n = usageLimits.size();
    usageLimits.sort((x, y) -> y - x);
    int l = 1;
    int r = n;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(usageLimits, mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l;

  }

  private boolean check(List<Integer> usageLimits, int mid) {
    int need = 0;
    for (int i = 0; i < usageLimits.size(); i++) {
      if (usageLimits.get(i) >= mid + need) {
        need = 0;
      } else {
        need += mid - usageLimits.get(i);
      }
      mid--;
      mid = Math.max(0, mid);
    }
    return need <= 0;
  }
}
