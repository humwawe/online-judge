package leetcode.c106;

/**
 * @author hum
 */
public class C2 {
  public int longestSemiRepetitiveSubstring(String s) {
    int n = s.length();
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        String tmp = s.substring(i, j + 1);
        if (check(tmp)) {
          res = Math.max(res, j - i + 1);
        }
      }
    }
    return res;
  }

  private boolean check(String tmp) {
    int cnt = 0;
    for (int i = 0; i < tmp.length() - 1; i++) {
      if (tmp.charAt(i) == tmp.charAt(i + 1)) {
        cnt++;
      }
    }
    return cnt <= 1;
  }
}
