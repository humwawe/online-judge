package leetcode.c343;

/**
 * @author hum
 */
public class C4 {
  public String smallestBeautifulString(String s, int k) {
    int n = s.length();
    StringBuilder res = new StringBuilder(s);
    for (int i = n - 1; i >= 0; i--) {
      int cur = s.charAt(i) - 'a';
      if (cur + 1 <= k - 1) {
        int can = (cur + 1);
        for (; can < k; can++) {
          if (i - 1 >= 0 && can == s.charAt(i - 1) - 'a') {
            continue;
          }
          if (i - 2 >= 0 && can == s.charAt(i - 2) - 'a') {
            continue;
          }
          res.setCharAt(i, (char) (can + 'a'));

          for (int j = i + 1; j < n; j++) {
            for (char l = 'a'; l <= 'c'; l++) {
              if (j - 1 >= 0 && res.charAt(j - 1) == l) {
                continue;
              }
              if (j - 2 >= 0 && res.charAt(j - 2) == l) {
                continue;
              }
              res.setCharAt(j, l);
              break;
            }
          }
          return res.toString();
        }
      }
    }
    return "";
  }
}
