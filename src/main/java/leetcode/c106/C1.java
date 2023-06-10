package leetcode.c106;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class C1 {
  public boolean isFascinating(int n) {
    String s = "" + n + 2 * n + 3 * n;
    Set<Character> set = new HashSet<>();
    for (char c : s.toCharArray()) {
      set.add(c);
    }
    return s.length() == 9 && set.size() == 9 && !set.contains('0');
  }
}
