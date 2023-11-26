package leetcode.c373;

/**
 * @author hum
 */
public class C2 {
  public int beautifulSubstrings(String s, int k) {
    int n = s.length();
    int res = 0;
    for (int i = 0; i < n; i++) {
      int v = 0;
      int c = 0;
      for (int j = i; j < n; j++) {
        if (isV(s.charAt(j))) {
          v++;
        } else {
          c++;
        }
        if (v == c && v * c % k == 0) {
          res++;
        }
      }
    }
    return res;
  }

  private boolean isV(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
