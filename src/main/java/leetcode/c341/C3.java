package leetcode.c341;

/**
 * @author hum
 */
public class C3 {
  public int addMinimum(String word) {
    for (int i = 1; i <= 200; i++) {
      if (helper(i, word)) {
        return i * 3 - word.length();
      }
    }
    return 0;
  }

  private boolean helper(int cnt, String word) {
    String tmp = "abc".repeat(cnt);
    int len = tmp.length();
    int j = 0;
    for (int i = 0; i < len; i++) {
      if (j == word.length()) {
        return true;
      }
      if (tmp.charAt(i) == word.charAt(j)) {
        j++;
      }
    }
    return j == word.length();
  }
}
