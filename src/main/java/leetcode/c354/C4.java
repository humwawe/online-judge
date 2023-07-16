package leetcode.c354;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class C4 {
  Set<String> set;
  String word;

  public int longestValidSubstring(String word, List<String> forbidden) {
    set = new HashSet<>(forbidden);
    this.word = word;
    int n = word.length();
    int j = -1;
    int res = 0;
    for (int i = 0; i < n; i++) {
      while (j + 1 < n && !check(i, j + 1)) {
        j++;
      }
      res = Math.max(res, j - i + 1);
    }
    return res;
  }

  private boolean check(int i, int j) {
    for (int k = j; k >= Math.max(i, j - 10); k--) {
      String substring = word.substring(k, j + 1);
      if (set.contains(substring)) {
        return true;
      }
    }
    return false;
  }
}
