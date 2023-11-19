package leetcode.c372;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C2 {
  public long minimumSteps(String s) {
    int n = s.length();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        list.add(i);
      }
    }
    long res = 0;
    int cur = n - 1;
    for (int i = list.size() - 1; i >= 0; i--) {
      res += cur - list.get(i);
      cur--;
    }
    return res;
  }
}
