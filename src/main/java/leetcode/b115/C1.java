package leetcode.b115;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public List<Integer> lastVisitedIntegers(List<String> words) {
    List<Integer> list = new ArrayList<>();
    int cnt = 0;
    List<Integer> res = new ArrayList<>();
    for (String word : words) {
      if (word.equals("prev")) {
        cnt++;
        int size = list.size();
        if (size - cnt >= 0) {
          res.add(list.get(size - cnt));
        } else {
          res.add(-1);
        }
      } else {
        cnt = 0;
        list.add(Integer.valueOf(word));
      }
    }
    return res;
  }
}
