package leetcode.c352;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C2 {
  public List<List<Integer>> findPrimePairs(int n) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (i <= n - i) {
        if (check(i) && check(n - i)) {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          list.add(n - i);
          res.add(list);
        }
      }
    }
    return res;
  }

  private boolean check(int i) {
    for (int j = 2; j * j <= i; j++) {
      if (i % j == 0) {
        return false;
      }
    }
    return true;
  }
}
