package leetcode.b115;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C2 {
  public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    int zero = 0;
    int one = 1;
    for (int i = 0; i < groups.length; i++) {
      if (groups[i] == zero) {
        list1.add(words[i]);
        zero ^= 1;
      }
      if (groups[i] == one) {
        list2.add(words[i]);
        one ^= 1;
      }
    }
    if (list1.size() >= list2.size()) {
      return list1;
    } else {
      return list2;
    }
  }
}
