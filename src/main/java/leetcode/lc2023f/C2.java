package leetcode.lc2023f;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class C2 {
  public int adventureCamp(String[] expeditions) {
    String[] split = expeditions[0].split("->");
    Set<String> set = new HashSet<>();
    Collections.addAll(set, split);
    int res = 0;
    int idx = -1;
    for (int i = 1; i < expeditions.length; i++) {
      String[] ss = expeditions[i].split("->");

      int cnt = 0;
      Set<String> set1 = new HashSet<>(Arrays.asList(ss));
      for (String s : set1) {
        if (s.length() == 0) {
          continue;
        }
        if (!set.contains(s)) {
          cnt++;
        }
      }
      set.addAll(set1);
      if (cnt > res) {
        res = cnt;
        idx = i;
      }
    }
    return idx;
  }
}
