package leetcode.c330;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PF-2CRL0N
 */
public class C1 {
  public int distinctIntegers(int n) {
    Set<Integer> cur = new HashSet<>();
    cur.add(n);
    while (true) {
      Set<Integer> set = new HashSet<>();
      for (int i = 1; i <= n; i++) {
        for (Integer integer : cur) {
          if (integer % i == 1 && !cur.contains(i)) {
            set.add(i);
          }
        }
      }
      if (set.isEmpty()) {
        return cur.size();
      }
      cur.addAll(set);
    }
  }
}
