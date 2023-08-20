package leetcode.c359;

import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public boolean isAcronym(List<String> words, String s) {
    StringBuilder res = new StringBuilder();
    for (String word : words) {
      res.append(word.charAt(0));
    }
    return res.toString().equals(s);
  }
}
