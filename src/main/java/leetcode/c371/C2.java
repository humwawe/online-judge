package leetcode.c371;

import java.util.*;

/**
 * @author hum
 */
public class C2 {
  public List<String> findHighAccessEmployees(List<List<String>> access_times) {
    Map<String, List<String>> map = new HashMap<>();
    for (List<String> access_time : access_times) {
      map.computeIfAbsent(access_time.get(0), e -> new ArrayList<>()).add(access_time.get(1));
    }

    List<String> res = new ArrayList<>();
    for (String s : map.keySet()) {
      List<String> list = map.get(s);
      Collections.sort(list);

      for (int i = 0; i < list.size() - 2; i++) {
        String st = list.get(i);
        String ed = list.get(i + 2);
        if (check(st, ed)) {
          res.add(s);
          break;
        }
      }
    }
    return res;
  }

  private boolean check(String st, String ed) {
    int i = Integer.parseInt(st.substring(0, 2)) * 60 + Integer.parseInt(st.substring(2));
    int j = Integer.parseInt(ed.substring(0, 2)) * 60 + Integer.parseInt(ed.substring(2));
    return j - i < 60;
  }
}
