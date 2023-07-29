package leetcode.c355;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public List<String> splitWordsBySeparator(List<String> words, char separator) {
    List<String> res = new ArrayList<>();
    for (String word : words) {
      int last = 0;
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == separator) {
          String substring = word.substring(last, i);
          if (!substring.isEmpty()) {
            res.add(substring);
          }
          last = i + 1;
        }
      }
      if (last != word.length()) {
        res.add(word.substring(last));
      }
    }
    return res;
  }
}
