package leetcode.b97;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public int[] separateDigits(int[] nums) {
    List<Character> list = new ArrayList<>();
    for (int num : nums) {
      String s = String.valueOf(num);
      for (int i = 0; i < s.length(); i++) {
        list.add(s.charAt(i));
      }
    }
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i) - '0';
    }
    return res;
  }
}
