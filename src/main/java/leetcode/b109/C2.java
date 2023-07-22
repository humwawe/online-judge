package leetcode.b109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class C2 {
  public String sortVowels(String s) {
    char[] res = s.toCharArray();
    int n = res.length;
    boolean[] vis = new boolean[n];
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (helper(Character.toLowerCase(res[i]))) {
        list.add(res[i]);
        vis[i] = true;
      }
    }
    Collections.sort(list);
    int idx = 0;
    for (int i = 0; i < n; i++) {
      if (vis[i]) {
        res[i] = list.get(idx++);
      }
    }
    return new String(res);
  }

  private boolean helper(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
