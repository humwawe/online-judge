package leetcode.b116;

/**
 * @author hum
 */
public class C2 {
  public int minChanges(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i += 2) {
      if (s.charAt(i) != s.charAt(i + 1)) {
        res++;
      }
    }
    return res;
  }
}
