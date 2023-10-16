package leetcode.c367;

/**
 * @author hum
 */
public class C2 {
  public String shortestBeautifulSubstring(String s, int k) {
    int n = s.length();
    String res = "1".repeat(n + 1);
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '0') {
        continue;
      }
      int cnt = 0;
      for (int j = i; j < n; j++) {
        if (s.charAt(j) == '1') {
          cnt++;
        }

        if (cnt == k) {
          String t = s.substring(i, j + 1);
          if (t.length() < res.length()) {
            res = t;
          } else if (t.length() == res.length() && res.compareTo(t) > 0) {
            res = t;
          }
          break;
        }
      }
    }
    if (res.length() == n + 1) {
      return "";
    }
    return res;
  }
}
