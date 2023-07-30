package leetcode.c356;

/**
 * @author hum
 */
public class C3 {
  public String minimumString(String a, String b, String c) {
    String s = helper(a, b, c);
    s = min(s, helper(a, c, b));
    s = min(s, helper(b, a, c));
    s = min(s, helper(b, c, a));
    s = min(s, helper(c, a, b));
    s = min(s, helper(c, b, a));
    return s;
  }

  private String min(String s, String s2) {
    if (s.length() < s2.length()) {
      return s;
    } else if (s.length() > s2.length()) {
      return s2;
    } else {
      int i = s.compareTo(s2);
      return i >= 0 ? s2 : s;
    }
  }

  private String helper(String a, String b, String c) {
    String res = merge(a, b);
    res = merge(res, c);
    return res;

  }

  private String merge(String a, String b) {
    if (a.contains(b)) {
      return a;
    }

    for (int i = b.length() - 1; i >= 0; i--) {
      if (a.endsWith(b.substring(0, i + 1))) {
        return a + b.substring(i + 1);
      }
    }
    return a + b;
  }
}
