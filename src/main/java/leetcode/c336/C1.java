package leetcode.c336;

/**
 * @author hum
 */
public class C1 {
  public int vowelStrings(String[] words, int left, int right) {
    String s = "aeiou";
    int res = 0;
    for (int i = left; i <= right; i++) {
      char c1 = words[i].charAt(0);
      char c2 = words[i].charAt(words[i].length() - 1);
      if (s.indexOf(c1) != -1 && s.indexOf(c2) != -1) {
        res++;
      }
    }
    return res;
  }
}
